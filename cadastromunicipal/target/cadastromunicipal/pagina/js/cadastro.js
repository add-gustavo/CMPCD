document.getElementById('nomelogin').addEventListener('blur', function () {
    var nomeLogin = document.getElementById('nomelogin').value;
    console.log("Valor enviado (nomeLogin):", nomeLogin);  // Console do valor enviado

    // Fazer a checagem assíncrona (AJAX)
    fetch('/cadastromunicipal/controlenomelogin', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ nomeLogin: nomeLogin })
    })
        .then(response => response.json())
        .then(data => {
            console.log("Resposta recebida:", data);  // Console dos dados recebidos

            var nomeLoginError = document.getElementById('nomeLoginError');
            var submitButton = document.getElementById('submitButton');  // Supondo que o botão de envio tenha o id 'submitButton'

            if (data.exists) {
                // Exibe a mensagem de erro e desabilita o botão de envio
                nomeLoginError.style.display = 'inline';
                submitButton.disabled = true; // Desabilita o botão
            } else {
                // Esconde a mensagem de erro e habilita o botão de envio
                nomeLoginError.style.display = 'none';
                submitButton.disabled = false; // Habilita o botão
            }
        })
        .catch(error => console.error('Erro:', error));
});

document.getElementById('email').addEventListener('blur', function () {
    var email = document.getElementById('email').value;
    console.log("Valor enviado (email):", email);  // Console do valor enviado

    // Fazer a checagem assíncrona (AJAX)
    fetch('/cadastromunicipal/controleemail', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email: email }) // Mudando para 'email'
    })
        .then(response => response.json())
        .then(data => {
            console.log("Resposta recebida:", data);  // Console dos dados recebidos

            var nomeLoginError = document.getElementById('nomeLoginError');
            var submitButton = document.getElementById('submitButton');  // Supondo que o botão de envio tenha o id 'submitButton'

            if (data.exists) {
                // Exibe a mensagem de erro e desabilita o botão de envio
                nomeLoginError.style.display = 'inline';
                submitButton.disabled = true; // Desabilita o botão
            } else {
                // Esconde a mensagem de erro e habilita o botão de envio
                nomeLoginError.style.display = 'none';
                submitButton.disabled = false; // Habilita o botão
            }
        })
        .catch(error => console.error('Erro:', error));
});
