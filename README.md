#  gooFrete
## Introdução
O sistema gooFrete tem como finalidade auxiliar no processo de fretes em uma empresa, com os dados de transportadores, veículos e viagens a serem realizadas.

## Instalação
- Ter o SQL Server Management Studio versão 19+;
- Rodar os scripts de criação de tabela contidos na pasta scripts;
- Efetuar o download ZIP do projeto, verificar se a versão do java é compatível com a máquina, caso negativo modificar no arquivo pom.xml;
- Adicionar a dependência AbsoluteLayout-RELEASE65.jar.

## Como utilizar
- O programa inicializa na janela home e contém um campo “Teste”, (com o comando System.exit(0);), assim como nesse campo em todas as janelas, localizada no campo superior direito, há uma imagem junto com a escrita “Logout” para fechar as janelas;
- Para cadastrar os transportadores e veículos deve entrar no menu “Cadastros”, este contém duas opções;
Ao selecionar "Transportador" abre a janela Cadastros > Transportador, nela se deve inserir os dados, razão social, CNPJ/CPF, endereço, bairro, cidade, estado, CEP, país, tipo de transportador, telefone e clicar no botão “Novo”. O botão “Atualizar Cadastro” irá atualizar os dados do transportador, limpar os campos e atualizar a tabela;
- Ao selecionar “Veículos” abre a janela Cadastros > Veículos, a esquerda há uma tabela com as colunas tipo, modelo, marca, placa e eixos, caso os dados dos campos localizados a direita forem inseridos corretamente a tabela será atualizada ao clicar no botão “Atualizar Cadastro”;
- Para ver as rotas/viagens deve-se entrar no menu “Rotas”, as viagens só podem ser realizadas quando vinculadas a um transportador e um veículo;
- O campo Adicionar destino aceita cidades no formato 'Cidade,UF', exemplo: 'Curitiba,PR', Código IBGE e CEP, com ou sem hífen;
- Há a possibilidade de alterar a ordem dos destinos, para isso no campo inferior direito existem 2 botões, “Sobe” e “Desce”, ao selecionar um item da tabela e clicar sobre o primeiro botão o item é realocado para um campo acima na tabela;
Para gerar os relatórios é necessário acessar o menu “Relatórios”, neste há 3 setores para gerar os respectivos relatórios e ao clicar no botão “Gerar Relatório” é exportado um arquivo PDF para a pasta resources na raiz do projeto.

## Funcionalidades
- Cadastros:
Cadastrar os transportadores, os veículos e realizar as viagens;
obs: Não há como realizar uma viagem sem a informação de veículo e transportador;
- Cálculo de pedágio;
- Relatórios:
Exportação do relatório em PDF dos transportadores, veículos e viagens.

## Referências:

#### Framework Hibernate:
1. [https://hibernate.org](https://hibernate.org)
#### JDBC para SQLServer:
2. [https://learn.microsoft.com/pt-br/sql/connect/jdbc/deploying-the-jdbc-driver?view=sql-server-ver16](https://learn.microsoft.com/pt-br/sql/connect/jdbc/deploying-the-jdbc-driver?view=sql-server-ver16)
#### Informações da API utilizada:
3. [https://rotasbrasil.com.br/configuracaoApi/v3](https://rotasbrasil.com.br/configuracaoApi/v3)
#### SQL Server Management Studio:
4. [https://learn.microsoft.com/en-us/sql/ssms/download-sql-server-management-studio-ssms?view=sql-server-ver16](https://learn.microsoft.com/en-us/sql/ssms/download-sql-server-management-studio-ssms?view=sql-server-ver16)
#### Jackson JSON Tutorial:
5. [https://www.baeldung.com/jackson](https://www.baeldung.com/jackson)
