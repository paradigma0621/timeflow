timeflow
========

Projeto de visualização gráfica de registros de CLOCK do ORG (GNU Emacs major mode)


Apresentação do Projeto
-----------------------
Parece algo simples ler um arquivo de texto (arquivos do tipo ORG) e computar registros numéricos numa determinada formatação padrão como a do exemplo abaixo:

CLOCK: [2021-09-30 qui 10:04]--[2021-09-30 qui 12:00] =>  1:56

Porém, se considerarmos a natureza do arquivo como um todo veremos que o mesmo se organiza em níveis de hierarquia de títulos com logs de tempo de clocks e mistura de conteúdos de textos.
	Implementado o código para detectar os níveis e subníveis, apresentando-os em uma TreeView do JavaFX, surge uma segunda questão:
	O JavaFX não reconhece individualmente os objetos de TreeItens de sua TreeView que estão recolhidos (o valor recebido do 'index' de um TreeItem considera apenas os itens visíveis). Como reconhecer os TreeItens filhos relativos aos seus pais?

Através do código desse projeto (ainda em desenvolvimento) é apresentada uma solução de identificação de hierarquia de TreeItens dentro de uma TreeView (mesmo que recolhidos), bem como a identificação de tempo total de registros de clocks de tarefas individuais, tendo por meta futura a geração gráfica de relatórios de tarefas/projetos selecionados.



Modo de operação
-----------------
Selecionar um item da TreeView que possua nodes filhos e clicar no botão: "Select One Line and Click Here". Com isso é reconhecida e apresetada uma relação de todos os dos timeclocks do TreeItens filhos do node pai.
