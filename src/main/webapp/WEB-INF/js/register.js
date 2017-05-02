var ve = new Vue({
    el: '.registerContainer',
    data: {
        username: '',
        password: '',
        realname: '',
        email: '',
        sex: '1',

        eye: 'glyphicon-eye-open',

        invalid: {
            username: {val: false},
            password: {val: false},
            realname: {val: false},
            email: {val: false}
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
        showPwd: function () {
            var type = $('#password').attr('type');
            if (type == 'password') {
                this.eye = 'glyphicon-eye-close';
                $('#password').attr('type', 'text');
            } else {
                this.eye = 'glyphicon-eye-open';
                $('#password').attr('type', 'password');
            }

        },

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
                    reg = globalV.reg.username;
                    break;
                case 'password':
                    obj = $('#password');
                    invalid = this.invalid.password;
                    error_msg = this.error_msg.password;
                    reg = globalV.reg.password;
                    break;
                case 'realname' :
                    obj = $('#realname');
                    invalid = this.invalid.realname;
                    error_msg = this.error_msg.realname;
                    reg = globalV.reg.realname;
                    break;
                case 'email' :
                    obj = $('#email');
                    invalid = this.invalid.email;
                    error_msg = this.error_msg.email;
                    reg = globalV.reg.email;
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

            $.post(basePath + 'user/register', $('#registerForm').serialize(), function (result) {
                switch (result.state) {
                    case -4:
                        alert(result.stateInfo);
                        break;
                    case 0 :
                        window.location.href = basePath + 'index';
                        break;
                }
            });
        }
    },
    watch: {
        'invalid.username': function (newVal, oldVal) {
            console.info('newVal: ' + newVal + ' oldVal: ' + oldVal);
        }
    }
});


