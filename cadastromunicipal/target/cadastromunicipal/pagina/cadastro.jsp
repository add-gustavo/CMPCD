<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="UTF-8">
            <title>CMPCD</title>
            <link rel="stylesheet" type="text/css" href="/cadastromunicipal/pagina/css/cadastro.css">
            <link rel="stylesheet" type="text/css" href="/cadastromunicipal/pagina/css/cadastroGlobal.css">
        </head>

        <body>
            <header class="green-color">
                <div class="ordem-header">
                    <div class="primeiro-header">
                        <a href="/cadastromunicipal/page?pagina=inicial" class="logo align">Lorem ipsum dolor</a>
                    </div>
                </div>

            </header>

            <section class="align">

                <div class="section-Titulo">
                    <h2>Cadastre-se</h2>
                    <div class="Titulo-login centerX">
                        <span id="labelbtt-login">Já tem Cadastro?</span>
                        <a href="/cadastromunicipal/page?pagina=login" id="btt-login">Entre aqui</a>
                    </div>
                </div>


                <form class="formulario align" action="/cadastromunicipal/controleuser?acao=fazer-cadastro"
                    method="POST" autocomplete="on">
                    <div class="section-template">
                        <!-- Nome Completo -->
                        <div class="ordem-formulario">
                            <label for="nomecompleto">Nome Completo:</label>
                            <input type="text" name="nomecompleto" id="nomecompleto"
                                placeholder="Digite seu nome completo" required>
                        </div>
                        <!-- Nome login -->
                        <div class="ordem-formulario">
                            <label for="nomelogin">Nome Login:</label>
                            <input type="text" name="nomelogin" id="nomelogin" placeholder="Digite seu nome de login"
                                required>
                        </div>
                        <!-- Senha -->
                        <div class="ordem-formulario">
                            <label for="senha">Senha:</label>
                            <input type="password" name="senha" id="senha" placeholder="Digite uma senha" required
                                minlength="8" required>
                        </div>
                        <div class="ordem-formulario">
                            <label for="email">Email:</label>
                            <input type="text" name="email" id="email" placeholder="Digite seu email" required>
                        </div>
                        <!-- Estado Civil e Gênero -->
                        <div>
                            <div class="ordem-formulario">
                                <label for="estadoCivil">Estado Civil:</label>
                                <label for="sexo">Sexo:</label>
                            </div>

                            <div class="ordem-formulario">
                                <select required id="estadoCivil" name="estadoCivil">
                                    <option value="" disabled selected>Selecione seu estado civil</option>
                                    <option value="solteiro">Solteiro(a)</option>
                                    <option value="casado">Casado(a)</option>
                                    <option value="divorciado">Divorciado(a)</option>
                                </select>
                                <select required id="sexo" name="sexo">
                                    <option value="" disabled selected>Selecione seu sexo</option>
                                    <option value="feminino">Feminino</option>
                                    <option value="masculino">Masculino</option>
                                    <option value="outros">Outro</option>
                                    <option value="Prefiro não informar">Prefiro não informar</option>
                                </select>
                            </div>
                        </div>
                        <!-- Data de Nascimento e CPF -->
                        <div>
                            <div class="ordem-formulario">
                                <label for="dataNascimento">Data de Nascimento:</label>
                                <label for="cpf">CPF:</label>
                            </div>
                            <div class="ordem-formulario">
                                <input type="date" name="dataNascimento" id="dataNascimento" required min="1924-01-01"
                                    max="2024-11-01">
                                <input type="text" name="cpf" id="cpf" placeholder="Digite seu CPF sem pontos ou traços"
                                    required minlength="11" maxlength="11">

                            </div>
                        </div>
                    </div>
                    <div class="section-Titulo">

                        <h2>Contato</h2>
                    </div>
                    <div class="section-template">
                        <div class="ordem-formulario">
                            <label for="endereco">Endereço:</label>
                            <input type="text" name="endereco" id="endereco" placeholder="Digite seu endereço completo"
                                required>
                        </div>
                        <div class="ordem-formulario">
                            <label for="telefone">Telefone:</label>
                            <input type="tel" name="telefone" id="telefone" placeholder="Digite seu telefone com DDD"
                                required minlength="11" maxlength="15">
                        </div>
                    </div>
                    <div class="section-Titulo">
                        <h2>Social</h2>
                    </div>
                    <div class="section-template">

                        <div class="ordem-formulario">
                            <label for="ocupacao">Ocupação:</label>
                            <select required id="ocupacao" name="ocupacao">
                                <option value="" disabled selected>Selecione sua ocupação</option>
                                <option value="estudante">Estudante</option>
                                <option value="empregado">Empregado</option>
                                <option value="desempregado">Desempregado</option>
                                <option value="outro">Outro</option>
                            </select>
                        </div>
                        <div class="ordem-formulario">
                            <label for="nivelEscolaridade">Nível de escolaridade:</label>
                            <select required id="nivelEscolaridade" name="nivelEscolaridade">
                                <option value="" disabled selected>Selecione seu nível de escolaridade</option>
                                <option value="fundamental_incompleto">Fundamental Incompleto</option>
                                <option value="fundamental_completo">Fundamental Completo</option>
                                <option value="medio_incompleto">Médio Incompleto</option>
                                <option value="medio_completo">Médio Completo</option>
                                <option value="superior_incompleto">Superior Incompleto</option>
                                <option value="superior_completo">Superior Completo</option>
                                <option value="pos_graduacao">Pós-Graduação</option>
                                <option value="mestrado">Mestrado</option>
                                <option value="doutorado">Doutorado</option>
                                <option value="outro">Outro</option>
                            </select>
                        </div>
                        <div class="ordem-formulario">
                            <label for="rendaFamiliarPCapita">Renda Familiar per Capita:</label>
                            <select required id="rendaFamiliarPCapita" name="rendaFamiliarPCapita">
                                <option value="" disabled selected>Selecione sua renda</option>
                                <option value="500">Até R$ 500</option>
                                <option value="1000">De R$ 500 a R$ 1.000</option>
                                <option value="1500">Acima de R$ 1.000</option>
                            </select>
                        </div>

                        <div class="ordem-formulario">
                            <label for="programaAssistenciaSocial">Programa de assistência social:</label>
                            <select required id="programaAssistenciaSocial" name="programaAssistenciaSocial">
                                <option value="" disabled selected>Selecione programa de assistência social</option>
                                <option value="500">Até R$ 500</option>
                                <option value="1000">De R$ 500 a R$ 1.000</option>
                                <option value="1500">Acima de R$ 1.000</option>
                            </select>
                        </div>
                    </div>
                    <div class="section-Titulo">
                        <h2>Medicação</h2>
                    </div>
                    <div class="section-template">

                        <div class="ordem-formulario">
                            <label for="usoMedicacao">Faz uso de medicação:</label>
                            <div class="align-self">
                                <input required type="radio" name="usoMedicacao" id="usoMedicacao-sim" value="true">
                                <label for="usoMedicacao-sim">Sim</label>
                                <input required type="radio" name="usoMedicacao" id="usoMedicacao-nao" value="false">
                                <label for="usoMedicacao-nao">Não</label>
                            </div>
                        </div>

                        <div class="ordem-formulario">
                            <label></label>
                            <textarea name="explicacaoUsoMedicacao" id="explicacaoUsoMedicacao"
                                placeholder="Informe o uso de Medicação" rows="4"></textarea>
                        </div>

                        <div class="ordem-formulario">
                            <label for="fazAtendimentoEspecialista">Faz atendimento com especialista:</label>
                            <div class="align-self">
                                <input required type="radio" name="fazAtendimentoEspecialista"
                                    id="fazAtendimentoEspecialista-sim" value="true"> <label
                                    for="fazAtendimentoEspecialista-sim">Sim</label>
                                <input required type="radio" name="fazAtendimentoEspecialista"
                                    id="fazAtendimentoEspecialista-nao" value="false"> <label
                                    for="fazAtendimentoEspecialista-nao">Não</label>
                            </div>
                        </div>
                        <div class="ordem-formulario">
                            <label></label>
                            <textarea name="explicacaoAtendimentoEspecialista" id="explicacaoAtendimentoEspecialista"
                                placeholder="Informe quais especialistas você faz atendimento" rows="4"></textarea>
                        </div>
                        <div class="ordem-formulario">
                            <label for="participaCentroApoio">Participa de algum centro de apoio:</label>
                            <div class="align-self">
                                <input required type="radio" name="participaCentroApoio" id="participaCentroApoio-sim"
                                    value="true">
                                <label for="participaCentroApoio-sim">Sim</label>
                                <input required type="radio" name="participaCentroApoio" id="participaCentroApoio-nao"
                                    value="false">
                                <label for="participaCentroApoio-nao">Não</label>
                            </div>
                        </div>
                        <div class="ordem-formulario">
                            <label></label>
                            <textarea name="explicacaoParticipacaoCentroApoio" id="explicacaoParticipacaoCentroApoio"
                                placeholder="Informe os centros de apoio que participa" rows="4"></textarea>
                        </div>
                        <div class="ordem-formulario">
                            <label for="historicoMedico">Histórico Médico Relevante:</label>
                            <textarea name="historicoMedico" id="historicoMedico"
                                placeholder="Informe seu histórico médico, se houver" rows="4"></textarea>
                        </div>
                    </div>

                    <div class="section-Titulo">
                        <h2>Aspectos da Deficiência</h2>
                    </div>
                    <div class="section-template">
                        <div class="ordem-formulario">
                            <label for="tipoDeficiencia">Deficiência / Necessidade Especial:</label>
                            <select required id="tipoDeficiencia" name="tipoDeficiencia">
                                <option value="" disabled selected>Selecione sua deficiência</option>
                                <option value="fisica">Física</option>
                                <option value="visual">Visual</option>
                                <option value="auditiva">Auditiva</option>
                                <option value="intelectual">Intelectual</option>
                                <option value="outro">Outro</option>
                            </select>
                        </div>

                        <div class="ordem-formulario">
                            <label for="necessidadeEquipamento">Necessita de equipamento:</label>
                            <div class="align-self">
                                <input required type="radio" name="necessidadeEquipamento"
                                    id="necessidadeEquipamento-sim" value="true">
                                <label for="necessidadeEquipamento-sim">Sim</label>
                                <input required type="radio" name="necessidadeEquipamento"
                                    id="necessidadeEquipamento-nao" value="false">
                                <label for="necessidadeEquipamento-nao">Não</label>
                            </div>
                        </div>
                        <div class="ordem-formulario">
                            <label></label>
                            <textarea name="explicacaoNecessidadeEquipamento" id="explicacaoNecessidadeEquipamento"
                                placeholder="Informe se necessitar de equipamento" rows="4"></textarea>
                        </div>

                        <div class="ordem-formulario">
                            <label for="necessidadeTransporteAdaptado">Necessita de transporte adaptado:</label>
                            <div class="align-self">
                                <input required type="radio" name="necessidadeTransporteAdaptado"
                                    id="necessidadeTransporteAdaptado-sim" value="true"> <label
                                    for="necessidadeTransporteAdaptado-sim">Sim</label>
                                <input required type="radio" name="necessidadeTransporteAdaptado"
                                    id="necessidadeTransporteAdaptado-nao" value="false"> <label
                                    for="necessidadeTransporteAdaptado-nao">Não</label>
                            </div>
                        </div>
                        <div class="ordem-formulario">
                            <label></label>
                            <textarea name="explicacaoNecessidadeAdaptacao" id="explicacaoNecessidadeAdaptacao"
                                placeholder="Informe os transportes que necessitar de transporte Adaptado "
                                rows="4"></textarea>
                        </div>

                        <div class="ordem-formulario">
                            <label for="necessidadeAdaptacaoLocalAtendimento">Necessita de adaptação no local de
                                atendimento:</label>
                            <div class="align-self">
                                <input required type="radio" name="necessidadeAdaptacaoLocalAtendimento"
                                    id="necessidadeAdaptacaoLocalAtendimento-sim" value="true"> <label
                                    for="necessidadeAdaptacaoLocalAtendimento-sim">Sim</label>
                                <input required type="radio" name="necessidadeAdaptacaoLocalAtendimento"
                                    id="necessidadeAdaptacaoLocalAtendimento-nao" value="false"> <label
                                    for="necessidadeAdaptacaoLocalAtendimento-nao">Não</label>
                            </div>
                        </div>
                        <div class="ordem-formulario">
                            <label></label>
                            <textarea name="explicacaoNecessidadeAdaptacaoLocalAtendimento"
                                id="explicacaoNecessidadeAdaptacaoLocalAtendimento"
                                placeholder="Informe se Necessitar de que tipo Adaptacao no Local de Atendimento"
                                rows="4"></textarea>
                        </div>

                        <div class="ordem-formulario">
                            <label for="necessidadeApoioEducacional">Necessita de apoio educacional:</label>
                            <div class="align-self">
                                <input required type="radio" name="necessidadeApoioEducacional"
                                    id="necessidadeApoioEducacional-sim" value="true">
                                <label for="necessidadeApoioEducacional-sim">Sim</label>
                                <input required type="radio" name="necessidadeApoioEducacional"
                                    id="necessidadeApoioEducacional-nao" value="false">
                                <label for="necessidadeApoioEducacional-nao">Não</label>
                            </div>
                        </div>
                        <div class="ordem-formulario">
                            <label></label>
                            <textarea name="necessidadeEducacional" id="necessidadeEducacional"
                                placeholder="Informe se necessitar de apoio Educacional" rows="4"></textarea>
                        </div>

                        <div class="ordem-formulario">
                            <label for="necessidadeAcompanhante">Necessita de acompanhante/responsável:</label>
                            <div class="align-self">
                                <input required type="radio" name="necessidadeAcompanhante"
                                    id="necessidadeAcompanhante-sim" value="true">
                                <label for="necessidadeAcompanhante-sim">Sim</label>
                                <input required type="radio" name="necessidadeAcompanhante"
                                    id="necessidadeAcompanhante-nao" value="false">
                                <label for="necessidadeAcompanhante-nao">Não</label>
                            </div>
                        </div>
                    </div>
                    <!-- Deficiência -->
                    <div class="section-Titulo">
                        <h2>Responsável</h2>
                    </div>
                    <div class="section-template">

                        <div class="ordem-formulario">
                            <label for="nomecompletoResponsavel">Nome Completo:</label>
                            <input type="text" name="nomecompletoResponsavel" id="nomecompletoResponsavel"
                                placeholder="Digite nome Completo do Responsável para mais informaçõe">
                        </div>
                        <div class="ordem-formulario">
                            <label for="emailResponsavel">Email:</label>
                            <input type="text" name="emailResponsavel" id="emailResponsavel"
                                placeholder="Digite email do responsável">
                        </div>
                        <div class="ordem-formulario">
                            <label for="enderecoResponsavel">Endereço:</label>
                            <input type="text" name="enderecoResponsavel" id="enderecoResponsavel"
                                placeholder="Digite seu endereço completo do responsável">
                        </div>
                        <div class="ordem-formulario">
                            <label for="telefoneResponsavel">Telefone:</label>
                            <input type="tel" name="telefoneResponsavel" id="telefoneResponsavel"
                                placeholder="Digite o telefone com DDD do responsável">
                        </div>

                    </div>


                    <div class="align">
                        <input class="submit-btt green-color" type="submit" value="Cadastrar">
                    </div>

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
        <script src="inicial.js"></script>

        </html>