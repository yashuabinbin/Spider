var ve = new Vue({
    el: '.pwdContainer',
    data: {
        email: ''
    },
    methods: {
        sendEmail: function (e) {
            if (!this.email) {
                alert('请填写邮箱');
                return false;
            }
            if (!globalV.reg.email.test(this.email)) {
                alert('请输入正确的邮箱');
                return false;
            }

            var btn = $(e.target);
            var orginBack = $(btn).css('background-color');

            //开始倒计时
            var countDown = 60;

            $(btn).attr('disabled', true);

            $.ajax({
                type: 'post',
                url: basePath + 'user/' + this.email + '/sendPwdEmail',
                dateType: 'json',
                success: function (result) {
                    if (result.state == -6) {
                        $(btn).attr('disabled', false);
                        alert(result.stateInfo);
                    } else {
                        $(btn).css('background-color', '#bfbfbf').text('重新发送(' + countDown + ')');
                        countDown--;

                        var interval = setInterval(function () {
                            if (countDown == 0) {
                                $(btn).attr('disabled', false).css('background-color', orginBack).text('Send');
                                window.clearInterval(interval);
                            } else {
                                $(btn).text('重新发送(' + countDown + ')');
                                countDown--;
                            }
                        }, 1000);
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $(btn).attr('disabled', false);
                }
            });
        }
    }
});