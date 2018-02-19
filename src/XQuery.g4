grammar  XQuery;

ap
  : 'doc(' fileName ')' '/' rp        #slash
  | 'document(' fileName ')' '/' rp   #slash
  | 'doc(' fileName ')' '//' rp       #dSlash
  | 'document(' fileName ')' '//' rp  #dSlash
  ;

rp
  : tagName           #tag
  | '*'               #star
  | '.'               #dot
  | '..'              #ddot
  | 'text()'          #text
  | '@'attName        #attribute
  | '(' rp ')'        #paren
  | rp '/' rp         #slashRP
  | rp '//' rp        #dslashRP
  | rp '[' filter ']' #filterRP
  | rp ',' rp         #commaRP
  ;

filter
  : rp                   #rpFilter
  | rp '=' rp            #eqFilter
  | rp 'eq' rp           #eqFilter
  | rp '==' rp           #isFilter
  | rp 'is' rp           #isFilter
  | '(' filter ')'       #parenFilter
  | filter 'and' filter  #andFilter
  | filter 'or' filter   #orFilter
  | 'not' filter         #notFilter
  ;

xq
  : var                                             #varXQ
  | stringConstant                                  #strXQ
  | ap                                              #apXQ
  | '(' xq ')'                                      #parenXQ
  | xq ',' xq                                       #commaXQ
  | xq '/' rp                                       #slashXQ
  | xq '//' rp                                      #dslashXQ
  | '<' tagName '>' '{' xq '}' '</' tagName '>'     #tagXQ      // back reference?
  | forClause letClause? whereClause? returnClause  #flwrXQ
  | letClause xq                                    #letXQ
  ;

forClause
  : 'for' var 'in' xq (',' var 'in' xq)*    #forCl
  ;

letClause
  : 'let' var ':=' xq (',' var ':=' xq)*    #letCl
  ;

whereClause
  : 'where' cond                            #whereCl
  ;

returnClause
  : 'return' xq                             #retCl
  ;

cond
  : xq '=' xq                                               #eqCond
  | xq 'eq' xq                                              #eqCond
  | xq '==' xq                                              #isCond
  | xq 'is' xq                                              #isCond
  | 'empty' '(' xq ')'                                      #empCond
  | 'some' var 'in' xq (',' var 'in' xq)* 'satisfies' cond  #someCond
  | '(' cond ')'                                            #parenCond
  | cond 'and' cond                                         #andCond
  | cond 'or' cond                                          #orCond
  | 'not' cond                                              #notCond
  ;


fileName        : STRINGCONSTANT;
tagName         : STRING;
attName         : STRING;
var             : '$' STRING;
stringConstant  : STRINGCONSTANT;


//SENTENCE: CHARANDSPACE+;
STRING: CHAR+;
CHAR: ('a'..'z' | 'A'..'Z' | '0'..'9' | '_' | '.');
//DQUOTE: '"';
STRINGCONSTANT: '"' ~'"'* '"';
//CHARANDSPACE: ('a'..'z' | 'A'..'Z' | '0'..'9' | '_' | '.' | ' ');
WS: [ \t\r\n]+ -> skip;