<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <title>Perfil</title>
    <link rel="stylesheet" type="text/css" href="/cadastromunicipal/pagina/css/perfil.css">
    <link rel="stylesheet" type="text/css" href="/cadastromunicipal/pagina/css/perfilGlobal.css">
</head>

<body>
    <header class="green-color">
        <div class="ordem-header">
            <div class="primeiro-header">
                <a href="/cadastromunicipal/principal.jsp" class="logo align">Lorem ipsum dolor</a>
            </div>
        </div>
    </header>

    <section class=" align">
        <div class="section-Titulo">
            <h2>Perfil do Usuário</h2>
        </div>
        <form class="formulario align">
            <div class="section-template">
                <h3>Informações Pessoais</h3>
                <label>Nome Completo:</label>
                <input type="text" value="${usuarioPcd.nomeCompleto}" readonly><br>
                <label>Nome Login:</label>
                <input type="text" name="usuarioPcd.nomeLogin" value="${usuarioPcd.nomeLogin}" readonly><br>
                <label>Email:</label>
                <input type="email" value="${usuarioPcd.email}" readonly><br>
                <label>Estado Civil:</label>
                <input type="text" value="${usuarioPcd.estadoCivil}" readonly><br>
                <label>Sexo:</label>
                <input type="text" value="${usuarioPcd.sexo}" readonly><br>
                <label>Data de Nascimento:</label>
                <input type="text" value="${usuarioPcd.dataNascimento}" readonly><br>
                <label>CPF:</label>
                <input type="text" value="${usuarioPcd.cpf}" readonly><br>
            </div>

            <!-- Contato -->
            <div class="section-template">
                <h3>Contato</h3>
                <label>Endereço:</label>
                <input type="text" value="${contato.endereco}" readonly><br>
                <label>Telefone:</label>
                <input type="text" value="${contato.telefone}" readonly><br>
            </div>

            <!-- Informações Sociais -->
            <div class="section-template">
                <h3>Social</h3>
                <label>Ocupação:</label>
                <input type="text" value="${social.ocupacao}" readonly><br>
                <label>Nível de Escolaridade:</label>
                <input type="text" value="${social.nivelEscolaridade}" readonly><br>
                <label>Renda Familiar per Capita:</label>
                <input type="text" value="${social.rendaFamiliarPcapita}" readonly><br>
                <label>Programa de Assistência Social:</label>
                <input type="text" value="${social.programaAssistenciaSocial}" readonly><br>
            </div>

            <!-- Informações Médicas -->
            <div class="section-template">
                <h3>Medicação e Saúde</h3>
                <label>Faz uso de medicação:</label>
                <input type="text" value="${medico.usoMedicacao ? 'Sim' : 'Não'}" readonly><br>
                <label>Descrição:</label>
                <input type="text" value="${medico.explicacaoUsoMedicacao}" readonly><br>
                <label>Atendimento com Especialista:</label>
                <input type="text" value="${medico.atendimentoEspecialista ? 'Sim' : 'Não'}" readonly><br>
                <label>Descrição:</label>
                <input type="text" value="${medico.explicacaoAtendimentoEspecialista}" readonly><br>
                <label>Histórico Médico:</label>
                <input type="text" value="${medico.historicoMedicoRelevante}" readonly><br>
            </div>

            <!-- Aspectos da Deficiência -->
            <div class="section-template">
                <h3>Aspectos da Deficiência</h3>
                <label>Deficiência:</label>
                <input type="text" value="${deficiencia.tipoDeficiencia}" readonly><br>
                <label>Necessita de Equipamento:</label>
                <input type="text" value="${deficiencia.necessidadeEquipamento ? 'Sim' : 'Não'}" readonly><br>
                <label>Descrição:</label>
                <input type="text" value="${deficiencia.explicacaoNecessidadeEquipamento}" readonly><br>
                <label>Necessita de Transporte Adaptado:</label>
                <input type="text" value="${deficiencia.necessidadeAdaptacao ? 'Sim' : 'Não'}" readonly><br>
                <label>Descrição:</label>
                <input type="text" value="${deficiencia.explicacaoNecessidadeAdaptacao}" readonly><br>
                <label>Necessita de Adaptação no local de atendimento:</label>
                <input type="text" value="${deficiencia.necessidadeAdaptacaoLocalAtendimento ? 'Sim' : 'Não'}"
                    readonly><br>
                <label>Descrição:</label>
                <input type="text" value="${deficiencia.explicacaoNecessidadeAdaptacaoLocalAtendimento}" readonly><br>
                <label>Necesita de apoio Educacional:</label>
                <input type="text" value="${deficiencia.necessidadeEducacional}" readonly><br>

            </div>

            <!-- Informações do Responsável -->
            <div class="section-template">
                <h3>Responsável</h3>
                <label>Nome Completo:</label>
                <input type="text" value="${responsavel.nomeCompleto}" readonly><br>
                <label>Email:</label>
                <input type="email" value="${responsavel.email}" readonly><br>
                <label>Endereço:</label>
                <input type="text" value="${responsavel.endereco}" readonly><br>
                <label>Telefone:</label>
                <input type="text" value="${responsavel.telefone}" readonly><br>
            </div>
            <div class="align">
                <input class="submit-btt green-color" type="submit" value="Salvar Informações">
            </div>
        </form>
        <form action="/cadastromunicipal/controleuser?acao=authenticacao" method="POST">
            <button type="submit">Excluir conta</button>
        </form>

    </section>
    <footer class="green-color align">

        <div>

        </div>
        <div>
            <ul>
                <li>Instagram</li>
                <li>Facebook</li>
                <li>Contato</li>
                <li>etc...</li>
            </ul>
        </div>


    </footer>
</body>

</html>