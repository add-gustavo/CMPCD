document.getElementById('nomelogin').addEventListener('blur', function () {
    var nomeLogin = document.getElementById('nomelogin').value;
    console.log("Valor enviado (nomeLogin):", nomeLogin);

    fetch('/cadastromunicipal/controlenomelogin', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ nomeLogin: nomeLogin })
    })
        .then(response => response.json())
        .then(data => {
            console.log("Resposta recebida:", data);

            var nomeLoginError = document.getElementById('nomeLoginError');
            var submitButton = document.getElementById('submitButton');

            if (data.exists) {
                nomeLoginError.style.display = 'inline';
                submitButton.disabled = true;
            } else {
                nomeLoginError.style.display = 'none';
                submitButton.disabled = false;
            }
        })
        .catch(error => console.error('Erro:', error));
});

document.getElementById('email').addEventListener('blur', function () {
    var email = document.getElementById('email').value;
    console.log("Valor enviado (email):", email);

    fetch('/cadastromunicipal/controleemail', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email: email })
    })
        .then(response => response.json())
        .then(data => {
            console.log("Resposta recebida:", data);

            var nomeLoginError = document.getElementById('nomeLoginError');
            var submitButton = document.getElementById('submitButton');

            if (data.exists) {
                nomeLoginError.style.display = 'inline';
                submitButton.disabled = true;
            } else {
                nomeLoginError.style.display = 'none';
                submitButton.disabled = false;
            }
        })
        .catch(error => console.error('Erro:', error));
});
