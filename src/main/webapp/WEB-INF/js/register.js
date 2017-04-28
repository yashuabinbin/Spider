var ve = new Vue({
    el: '.registerContainer',
    data: {
        username: '',
        password: '',
        realname: '',
        email: '',

        invalid: {
            username: {val: false},
            password: {val: false},
            realname: {val: false},
            email: {val: false}
        },

        reg: {
            username: /[a-zA-Z0-9]{3,16}/,
            password: /[a-zA-Z0-9]{5,16}/,
            email: /^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/,
            realname: /[\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*/
        },

        error_msg: {
            username: {
                is_null: '用户名不能为空',
                format_error: '请输入符合要求的用户名！用户名格式：3-16位英文或数字'
            },
            password: {
                is_null: '密码不能为空',
                format_error: '请输入符合要求的密码！密码格式：5-16位英文或数字'
            },
            realname: {
                is_null: '姓名不能为空',
                format_error: '请输入正确的名字！真名格式：2-5位中文'
            },
            email: {
                is_null: '邮箱不能为空',
                format_error: '请输入正确的邮箱！'
            }
        }
    },
    methods: {
        //弹出提示框
        showErrorMsg: function (obj, content, invalid) {
            invalid.val = true;

            obj.popover({
                trigger: 'manual',
                title: 'notice',
                placement: 'right',
                content: content
            });
            obj.popover('show');

            obj.unbind().bind('focus', function () {
                obj.popover('destroy');
            });
        },

        validItem: function (category, val) {
            var obj;
            var invalid;
            var error_msg;
            var reg;

            switch (category) {
                case 'username' :
                    obj = $('#username');
                    invalid = this.invalid.username;
                    error_msg = this.error_msg.username;
                    reg = this.reg.username;
                    break;
                case 'password':
                    obj = $('#password');
                    invalid = this.invalid.password;
                    error_msg = this.error_msg.password;
                    reg = this.reg.password;
                    break;
                case 'realname' :
                    obj = $('#realname');
                    invalid = this.invalid.realname;
                    error_msg = this.error_msg.realname;
                    reg = this.reg.realname;
                    break;
                case 'email' :
                    obj = $('#email');
                    invalid = this.invalid.email;
                    error_msg = this.error_msg.email;
                    reg = this.reg.email;
                    break;
            }

            if (!val) {
                this.showErrorMsg(obj, error_msg.is_null, invalid);
                return false;
            }

            if (!reg.test(val)) {
                this.showErrorMsg(obj, error_msg.format_error, invalid);
                return false;
            }

            invalid.val = false;
            return true;
        },

        //注册表单提交
        registerSubmit: function () {
            if (!this.validItem('username', this.username)) return;
            if (!this.validItem('realname', this.realname)) return;
            if (!this.validItem('email', this.email)) return;
            if (!this.validItem('password', this.password)) return;
        }
    },
    watch: {
        'invalid.username': function (newVal, oldVal) {
            console.info('newVal: ' + newVal + ' oldVal: ' + oldVal);
        }
    }
});


