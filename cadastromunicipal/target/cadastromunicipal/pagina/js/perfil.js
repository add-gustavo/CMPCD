document.addEventListener('DOMContentLoaded', function () {
    // Seleciona todos os ícones de editar
    const editIcons = document.querySelectorAll('.edit-icon');

    // Adiciona evento de clique para cada ícone de editar
    editIcons.forEach(icon => {
        icon.addEventListener('click', function () {
            // Encontra o contêiner de inputs relacionado ao ícone
            const sectionTemplate = this.closest('.section-template');
            const inputs = sectionTemplate.querySelectorAll('input');
            const selects = sectionTemplate.querySelectorAll('select'); // Seleciona os selects
            const textareas = sectionTemplate.querySelectorAll('textarea'); // Seleciona os textareas

            // Encontra o formulário ao qual o ícone pertence
            const form = this.closest('form');

            // Se está no estado "editar"
            if (this.classList.contains('edit-icon')) {
                // Habilita os inputs
                inputs.forEach(input => {
                    if (input.type === 'radio' || input.type === 'checkbox') {
                        input.removeAttribute('disabled');
                    } else {
                        input.removeAttribute('readonly');
                    }
                });

                // Habilita os selects
                selects.forEach(select => {
                    select.removeAttribute('disabled');
                });

                // Habilita os textareas
                textareas.forEach(textarea => {
                    textarea.removeAttribute('readonly');
                });

                // Atualiza o botão para "salvar"
                this.classList.remove('edit-icon', 'fa-edit');
                this.classList.add('save-icon', 'fa-save');
                this.title = "Salvar"; // Dica de acessibilidade (opcional)
            }
            // Se está no estado "salvar"
            else if (this.classList.contains('save-icon')) {
                // Garante que os selects estão habilitados antes da submissão
                selects.forEach(select => {
                    select.removeAttribute('disabled');
                });

                // Submete o formulário
                if (form) {
                    form.submit();
                }

                // Após o envio, desabilita os inputs novamente
                inputs.forEach(input => {
                    if (input.type === 'radio' || input.type === 'checkbox') {
                        input.setAttribute('disabled', true);
                    } else {
                        input.setAttribute('readonly', true);
                    }
                });

                // Desabilita os selects
                selects.forEach(select => {
                    select.setAttribute('disabled', true);
                });

                // Desabilita os textareas
                textareas.forEach(textarea => {
                    textarea.setAttribute('readonly', true);
                });

                // Atualiza o botão para "editar"
                this.classList.remove('save-icon', 'fa-save');
                this.classList.add('edit-icon', 'fa-edit');
                this.title = "Editar"; // Dica de acessibilidade (opcional)
            }
        });
    });
});
