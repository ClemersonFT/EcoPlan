O descarte inadequado de resíduos é um problema ambiental e social significativo. Quando o lixo é jogado em locais impróprios, como ruas, terrenos baldios e rios, ocorre contaminação do solo e da água, além do entupimento de sistemas de drenagem, o que pode provocar enchentes e danos ao ecossistema.
Socialmente, o acúmulo de resíduos favorece a proliferação de vetores de doenças e prejudica a qualidade de vida da população. Administrativamente, gera aumento de custos para o poder público, que precisa investir em limpezas emergenciais e manutenção urbana.
De acordo com a ABRELPE (Panorama dos Resíduos Sólidos no Brasil), milhões de toneladas de resíduos ainda recebem destinação inadequada todos os anos no país. Apesar da existência da Lei nº 12.305/2010, que instituiu a Política Nacional de Resíduos Sólidos (PNRS), os desafios na gestão e fiscalização do descarte continuam presentes. Dados do IBGE (Pesquisa Nacional de Saneamento Básico) também apontam desigualdades na coleta e tratamento de resíduos entre os municípios brasileiros, reforçando a necessidade de soluções mais eficazes e tecnológicas para enfrentar o problema.


Objetivo Geral
Desenvolver um sistema digital que auxilie a população no descarte adequado de resíduos, facilite a solicitação de coleta de itens de grande porte e permita o registro de denúncias de descarte irregular, contribuindo para a melhoria da gestão ambiental urbana.
Objetivos Específicos
●	Disponibilizar informações claras sobre como descartar corretamente diferentes tipos de resíduos.

●	Permitir o cadastro e gerenciamento de usuários.

●	Possibilitar a solicitação de coleta de objetos de grande porte.

●	Encaminhar automaticamente solicitações de coleta para instituições parceiras.

●	Permitir o registro de denúncias com imagens e descrição.

●	Encaminhar denúncias às autoridades competentes.

●	Informar ao usuário o status de suas solicitações e denúncias.

●	Oferecer canal de suporte para atendimento ao usuário.

●	Enviar notificações por e-mail sobre atualizações relevantes.

Público-Alvo
O público-alvo principal do sistema são jovens adultos entre 18 e 30 anos, especialmente aqueles que passaram recentemente a assumir responsabilidades domésticas e que ainda não possuem pleno conhecimento sobre as formas corretas de descarte de resíduos.
Muitas pessoas nessa faixa etária estão saindo da casa dos pais, iniciando a vida universitária ou profissional e passando a lidar, pela primeira vez, com questões como organização doméstica, descarte de lixo reciclável, resíduos eletrônicos, móveis antigos e objetos de grande porte. Nesse contexto, é comum surgirem dúvidas sobre onde e como descartar corretamente determinados itens.
O sistema busca atender essa necessidade oferecendo informações claras, acessíveis e organizadas, além de facilitar a solicitação de coleta e o registro de denúncias.
Embora o foco principal seja esse grupo, a plataforma também poderá ser utilizada por demais cidadãos interessados em realizar o descarte adequado, bem como por órgãos públicos e instituições parceiras responsáveis pelo atendimento das solicitações.


Requisitos funcionais:

RF01: Buscar informações de descarte do objeto a ser descartado;

RF02: Manter usuario por email, nome, CPF, localização e telefone;

RF03: O usuario tem a opção de ativar a verificação de duas etapas para a sua conta;

RF04: Solicitar a busca e coleta de itens de grande porte;

RF05: A solicitação de coleta deve ser automaticamente enviado para a instituição de descarte parceira;

RF06: O status de andamento da solicitação deve ser exibido ao usuario;

RF07: Denuncias podem ser feitas com uso de imagens e descrição do acontecido;

RF08: Ao receber a denuncia o sistema deve encaminhá-las às autoridades competentes e, se necessario, acionar uma instituição local de coleta;

RF09: O status de andamento da denuncia deve ser exibido o usuario;

RF10: Oferecer um canal de suporte via chat, email ou telefone.

 Requisitos não funcionais:

RFN01: O sistema deve ter uma base de dados que armazene informações sobre itens a serem descartados permitindo atualizações, inserções e consultas eficientes;

RNF02: A verificação de duas etapas deve ser suportada e integrada pelo sistema;

RNF03: O usuario deve ser notificado via email sobre o status da sua solicitação de coleta;

RNF04: O usuario deve ser notificado via email sobre o sucesso da sua denuncia;

Regra de negocio: 

RN01 – A solicitação de coleta de itens de grande porte só poderá ser realizada por usuários cadastrados e autenticados no sistema.

RN02 – A denúncia deverá conter obrigatoriamente descrição do ocorrido e pelo menos uma imagem anexada.

RN03 – O status da solicitação ou denúncia só poderá ser alterado por usuários com perfil administrativo ou por instituições parceiras autorizadas.

RN04 – Cada solicitação de coleta deverá estar vinculada a um endereço válido informado pelo usuário.

