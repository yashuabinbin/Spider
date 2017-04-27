var ve = new Vue({
    el: '.loginContainer',
    data: {
        username: '',
        password: ''
    },
    methods: {
        loginSubmit: function () {
            $.ajax({
                type: 'POST',
                url: basePath + '/checkLogin',
                dataType: 'json',
                data: {
                    username: this.username,
                    password: this.password
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                },
                success: function (data) {
                    switch (data.state) {
                        case -1:
                        case -2:
                            alert(data.stateInfo);
                            return;
                        case -3:
                            alert(data.stateInfo);
                            this.password = '';
                            return;
                        case 0:
                            window.location.href = basePath + "index";
                    }
                }
            });
        }
    }
});