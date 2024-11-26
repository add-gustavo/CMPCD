document.addEventListener('DOMContentLoaded', function () {
    const editIcons = document.querySelectorAll('.edit-icon');

    editIcons.forEach(icon => {
        icon.addEventListener('click', function () {
            const sectionTemplate = this.closest('.section-template');
            const inputs = sectionTemplate.querySelectorAll('input');
            const selects = sectionTemplate.querySelectorAll('select');
            const textareas = sectionTemplate.querySelectorAll('textarea');
            const form = this.closest('form');

            if (this.classList.contains('edit-icon')) {
                inputs.forEach(input => {
                    if (input.type === 'radio' || input.type === 'checkbox') {
                        input.removeAttribute('disabled');
                    } else {
                        input.removeAttribute('readonly');
                    }
                });

                selects.forEach(select => {
                    select.removeAttribute('disabled');
                });

                textareas.forEach(textarea => {
                    textarea.removeAttribute('readonly');
                });

                this.classList.remove('edit-icon', 'fa-edit');
                this.classList.add('save-icon', 'fa-save');
                this.title = "Salvar";
            }

            else if (this.classList.contains('save-icon')) {
                selects.forEach(select => {
                    select.removeAttribute('disabled');
                });

                if (form) {
                    form.submit();
                }

                inputs.forEach(input => {
                    if (input.type === 'radio' || input.type === 'checkbox') {
                        input.setAttribute('disabled', true);
                    } else {
                        input.setAttribute('readonly', true);
                    }
                });

                selects.forEach(select => {
                    select.setAttribute('disabled', true);
                });

                textareas.forEach(textarea => {
                    textarea.setAttribute('readonly', true);
                });

                this.classList.remove('save-icon', 'fa-save');
                this.classList.add('edit-icon', 'fa-edit');
                this.title = "Editar";
            }
        });
    });
});
document.getElementById('nomelogin').addEventListener('blur', function () {
    var nomeLogin = document.getElementById('nomelogin').value;

    fetch('/cadastromunicipal/controleuser/checar-nome-login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ nomeLogin: nomeLogin })
    })
        .then(response => response.json())
        .then(data => {
            if (data.exists) {
                document.getElementById('nomeLoginError').style.display = 'inline';
            } else {
                document.getElementById('nomeLoginError').style.display = 'none';
            }
        })
        .catch(error => console.error('Erro:', error));
});