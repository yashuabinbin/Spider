var ve = new Vue({
    el: '.loginContainer',
    data: {
        username: '',
        password: ''
    },
    methods: {
        loginSubmit: function () {
            alert(basePath);
        }
    }
});