grammar  XQuery;

ap
  : 'doc("' fileName '")' '/' rp  #slash
  | 'doc("' fileName '")' '//' rp #dSlash
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

fileName: STRING;
tagName : STRING;
attName : STRING;

STRING: CHAR+;
CHAR: ('a'..'z' | 'A'..'Z' | '0'..'9' | '_' | '.');
WS: [ \t\r\n]+ -> skip;