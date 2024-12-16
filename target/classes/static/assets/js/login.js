document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('loginButton').addEventListener('click', function (event) {
        event.preventDefault();
    
        const username = document.getElementById('username').value.trim();
        const password = document.getElementById('password').value.trim();
    
        if (!username || !password) {
            alert('Please enter both username and password.');
            return;
        }

        let urlLogin = '/login';
        urlLogin += '?username=' + encodeURIComponent(username) + '&password=' + encodeURIComponent(password);

        console.log('URL:', urlLogin);

        fetch(urlLogin, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => response.json())
          .then(data => {
              if (data) {
                  alert('Login successful!');
                  window.location.href = '/index';
              } else {
                  alert('Login failed. Please check your username and password.');
              }
          })
          .catch(error => console.error('Error:', error));
    });
    
    

    var showPasswordButton = document.getElementById('toggle-password');
    if (!showPasswordButton) {
        return;
    }

    function showPassword() {
        var password = document.getElementById('password');
        if (password.type === 'password') {
            showPasswordButton.classList.replace('fa-eye', 'fa-eye-slash');
            password.type = 'text';
        } else {
            showPasswordButton.classList.replace('fa-eye-slash', 'fa-eye');
            password.type = 'password';
        }
    }

    showPasswordButton.addEventListener('click', showPassword);
});