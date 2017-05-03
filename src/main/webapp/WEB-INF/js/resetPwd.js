var ve = new Vue({
    el: '.pwdContainer',
    data: {
        password: '',
        confirmPassword: '',
        invalid: {
            password: {
                val: false,
            },
            confirmPassword: {
                val: false
            }
        },
        error_msg: {
            password: {
                is_null: '密码不能为空',
                format_error: '请输入符合要求的密码！密码格式：5-16位英文或数字'
            },
            confirmPassword: {
                is_null: '确认密码不能为空',
                not_equal: '两次密码输入不一致'
            }
        }
    },
    methods: {
        resetPassword: function () {
            if (!this.password) {
                globalV.showErrorMsg($('#password'), this.error_msg.password.is_null, this.invalid.password);
                return;
            }
            if (!globalV.reg.password.test(this.password)) {
                globalV.showErrorMsg($('#password'), this.error_msg.password.format_error, this.invalid.password);
                return;
            }
            this.invalid.password = false;

            if (!this.confirmPassword) {
                globalV.showErrorMsg($('#confirmPassword'), this.error_msg.confirmPassword.is_null, this.invalid.confirmPassword);
                return;
            }
            if (this.confirmPassword != this.password) {
                globalV.showErrorMsg($('#confirmPassword'), this.error_msg.confirmPassword.not_equal, this.invalid.confirmPassword);
                return;
            }
            this.invalid.confirmPassword = false;

            //重置密码
        }
    }
});