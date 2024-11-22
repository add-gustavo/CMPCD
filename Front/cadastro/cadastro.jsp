<!DOCTYPE html>
<html lang="pt-br">
<meta charset="UTF-8">
<title>CMPCD</title>
<link rel="stylesheet" type="text/css" href="/cadastromunicipal/pagina/css/cadastro.css">
<link rel="stylesheet" type="text/css" href="/cadastromunicipal/pagina/css/cadastroGlobal.css">
</head>

<body>
    <header class="green-color">
        <div class="ordem-header">
            <div class="primeiro-header">
                <a class="logo align">Lorem ipsum dolor</a>
            </div>
        </div>

    </header>

    <section class="align">

        <div class="section-Titulo">
            <h2>Cadastre-se</h2>
            <div class="Titulo-login centerX">
                <span id="labelbtt-login">Já tem Cadastro?</span>
                <a id="btt-login">Entre aqui</a>
            </div>
        </div>

        <div class="section-template align">
            <form class="formulario" action="" method="POST" autocomplete="on">
                <!-- Nome Completo -->
                <div class="ordem-formulario">
                    <label for="name">Nome Completo:</label>
                    <input type="text" name="name" id="name" placeholder="Digite seu nome completo" required>
                </div>

                <!-- CPF -->
                <div class="ordem-formulario">
                    <label for="cpf">CPF:</label>
                    <input type="text" name="cpf" id="cpf" placeholder="Digite seu CPF" required>
                </div>

                <!-- Deficiência -->
                <div class="ordem-formulario">
                    <label for="deficiencia">Deficiência / Necessidade Especial:</label>
                    <select id="deficiencia" name="deficiencia">
                        <option value="" disabled selected>Selecione sua deficiência</option>
                        <option value="fisica">Física</option>
                        <option value="visual">Visual</option>
                        <option value="auditiva">Auditiva</option>
                        <option value="intelectual">Intelectual</option>
                        <option value="outro">Outro</option>
                    </select>
                </div>

                <!-- Grau de Deficiência -->
                <div class="ordem-formulario">
                    <label for="graudeficiencia">Grau de Deficiência:</label>
                    <select id="graudeficiencia" name="graudeficiencia">
                        <option value="" disabled selected>Selecione o grau</option>
                        <option value="leve">Leve</option>
                        <option value="moderada">Moderada</option>
                        <option value="grave">Grave</option>
                    </select>
                </div>

                <!-- Data de Nascimento e Telefone -->
                <div>
                    <div class="ordem-formulario">
                        <label for="dataNascimento">Data de Nascimento:</label>
                        <label for="telefone">Telefone:</label>
                    </div>
                    <div class="ordem-formulario">
                        <input type="date" name="dataNascimento" id="dataNascimento" required min="1924-01-01"
                            max="2024-11-01">
                        <input type="tel" name="telefone" id="telefone" placeholder="Digite seu telefone com DDD"
                            required>
                    </div>
                </div>

                <!-- Endereço -->
                <div class="ordem-formulario">
                    <label for="endereco">Endereço:</label>
                    <input type="text" name="endereco" id="endereco" placeholder="Digite seu endereço completo"
                        required>
                </div>


                <!-- Ocupação -->
                <div class="ordem-formulario">
                    <label for="ocupacao">Ocupação:</label>
                    <select id="ocupacao" name="ocupacao">
                        <option value="" disabled selected>Selecione sua ocupação</option>
                        <option value="estudante">Estudante</option>
                        <option value="empregado">Empregado</option>
                        <option value="desempregado">Desempregado</option>
                        <option value="outro">Outro</option>
                    </select>
                </div>

                <!-- Gênero -->
                <div class="ordem-formulario">
                    <label for="genero">Gênero:</label>
                    <select id="genero" name="genero">
                        <option value="" disabled selected>Selecione seu gênero</option>
                        <option value="feminino">Feminino</option>
                        <option value="masculino">Masculino</option>
                        <option value="outro">Outro</option>
                    </select>
                </div>

                <!-- Estado Civil -->
                <div class="ordem-formulario">
                    <label for="Ecivil">Estado Civil:</label>
                    <select id="Ecivil" name="Ecivil">
                        <option value="" disabled selected>Selecione seu estado civil</option>
                        <option value="solteiro">Solteiro(a)</option>
                        <option value="casado">Casado(a)</option>
                        <option value="divorciado">Divorciado(a)</option>
                    </select>
                </div>

                <!-- Renda Familiar -->
                <div class="ordem-formulario">
                    <label for="renda">Renda Familiar per Capita:</label>
                    <select id="renda" name="renda">
                        <option value="" disabled selected>Selecione sua renda</option>
                        <option value="500">Até R$ 500</option>
                        <option value="1000">De R$ 500 a R$ 1.000</option>
                        <option value="1500">Acima de R$ 1.000</option>
                    </select>
                </div>

                <!-- Necessidades Específicas -->
                <div class="ordem-formulario">
                    <label for="responsavel">Necessita de acompanhante/responsável:</label>
                    <div class="align-self">
                        <input type="radio" name="responsavel" id="responsavel-sim" value="Sim"> <label
                            for="responsavel-sim">Sim</label>
                        <input type="radio" name="responsavel" id="responsavel-nao" value="Não"> <label
                            for="responsavel-nao">Não</label>
                    </div>
                </div>

                <div class="ordem-formulario">
                    <label for="equipamento">Necessita de equipamento:</label>
                    <div class="align-self">
                        <input type="radio" name="equipamento" id="equipamento-sim" value="Sim"> <label
                            for="equipamento-sim">Sim</label>
                        <input type="radio" name="equipamento" id="equipamento-nao" value="Não"> <label
                            for="equipamento-nao">Não</label>
                    </div>
                </div>

                <div class="ordem-formulario">
                    <label for="transporteadap">Necessita de transporte adaptado:</label>
                    <div class="align-self">
                        <input type="radio" name="transporteadap" id="transporteadap-sim" value="Sim"> <label
                            for="transporteadap-sim">Sim</label>
                        <input type="radio" name="transporteadap" id="transporteadap-nao" value="Não"> <label
                            for="transporteadap-nao">Não</label>
                    </div>
                </div>

                <div class="ordem-formulario">
                    <label for="localatendimento">Necessita de adaptação no local de atendimento:</label>
                    <div class="align-self">
                        <input type="radio" name="localatendimento" id="localatendimento-sim" value="Sim"> <label
                            for="localatendimento-sim">Sim</label>
                        <input type="radio" name="localatendimento" id="localatendimento-nao" value="Não"> <label
                            for="localatendimento-nao">Não</label>
                    </div>
                </div>

                <div class="ordem-formulario">
                    <label for="apoioEducacional">Necessita de apoio educacional:</label>
                    <div class="align-self">
                        <input type="radio" name="apoioEducacional" id="apoioEducacional-sim" value="Sim"> <label
                            for="apoioEducacional-sim">Sim</label>
                        <input type="radio" name="apoioEducacional" id="apoioEducacional-nao" value="Não"> <label
                            for="apoioEducacional-nao">Não</label>
                    </div>
                </div>

                <div class="ordem-formulario">
                    <label for="medicacao">Faz uso de medicação:</label>
                    <div class="align-self">
                        <input type="radio" name="medicacao" id="medicacao-sim" value="Sim"> <label
                            for="medicacao-sim">Sim</label>
                        <input type="radio" name="medicacao" id="medicacao-nao" value="Não"> <label
                            for="medicacao-nao">Não</label>
                    </div>
                </div>

                <div class="ordem-formulario">
                    <label for="centroapoio">Participa de algum centro de apoio:</label>
                    <div class="align-self">
                        <input type="radio" name="centroapoio" id="centroapoio-sim" value="Sim"> <label
                            for="centroapoio-sim">Sim</label>
                        <input type="radio" name="centroapoio" id="centroapoio-nao" value="Não"> <label
                            for="centroapoio-nao">Não</label>
                    </div>
                </div>

                <div class="ordem-formulario">
                    <label for="especialista">Faz atendimento com especialista:</label>
                    <div class="align-self">
                        <input type="radio" name="especialista" id="especialista-sim" value="Sim"> <label
                            for="especialista-sim">Sim</label>
                        <input type="radio" name="especialista" id="especialista-nao" value="Não"> <label
                            for="especialista-nao">Não</label>
                    </div>
                </div>

                <!-- Histórico Médico -->
                <div class="ordem-formulario">
                    <label for="historico">Histórico Médico Relevante:</label>
                    <textarea name="historico" id="historico" placeholder="Informe seu histórico médico, se houver"
                        rows="4"></textarea>
                </div>


                <div class="align">
                    <input class="submit-btt green-color" type="submit" value="Cadastrar">
                </div>

            </form>

        </div>

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
<script src="inicial.js"></script>

</html>