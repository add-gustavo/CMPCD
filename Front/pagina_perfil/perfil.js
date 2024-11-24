document.addEventListener('DOMContentLoaded', function () {
    // Seleciona todos os ícones de editar
    const editIcons = document.querySelectorAll('.edit-icon');

    // Adiciona evento de clique para cada ícone de editar
    editIcons.forEach(icon => {
        icon.addEventListener('click', function () {
            // Encontra o contêiner de inputs relacionado ao ícone
            const sectionTemplate = this.closest('.section-template');
            const inputs = sectionTemplate.querySelectorAll('input');
            const selects = sectionTemplate.querySelectorAll('select'); // Adiciona a seleção dos selects

            // Encontra o formulário ao qual o ícone pertence
            const form = this.closest('form');

            // Se está no estado "editar"
            if (this.classList.contains('edit-icon')) {
                // Habilita os inputs
                inputs.forEach(input => {
                    input.removeAttribute('readonly');
                });

                // Habilita os selects
                selects.forEach(select => {
                    select.removeAttribute('disabled');
                });

                // Atualiza o botão para "salvar"
                this.classList.remove('edit-icon', 'fa-edit');
                this.classList.add('save-icon', 'fa-save');
                this.title = "Salvar"; // Dica de acessibilidade (opcional)
            }
            // Se está no estado "salvar"
            else if (this.classList.contains('save-icon')) {
                // Desabilita os inputs novamente
                inputs.forEach(input => {
                    input.setAttribute('readonly', true);
                });

                // Desabilita os selects
                selects.forEach(select => {
                    select.setAttribute('disabled', true);
                });

                // Submete o formulário ao salvar
                if (form) {
                    form.submit();
                }

                // Atualiza o botão para "editar"
                this.classList.remove('save-icon', 'fa-save');
                this.classList.add('edit-icon', 'fa-edit');
                this.title = "Editar"; // Dica de acessibilidade (opcional)
            }
        });
    });
});
