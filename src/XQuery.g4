grammar  XQuery;

ap
  : 'doc("' fileName '")' '/' rp  #slash
  | 'doc("' fileName '")' '//' rp #dSlash
  ;

rp
  : tagName
  | '*'
  | '.'
  | '..'
  | 'text()'
  | '@'attName
  | '(' rp ')'
  | rp '/' rp
  | rp '//' rp
  | rp '[' filter ']'
  | rp ',' rp
  ;

filter
  : rp
  | rp '=' rp
  | rp 'eq' rp
  | rp '==' rp
  | rp 'is' rp
  | '(' filter ')'
  | filter 'and' filter
  | filter 'or' filter
  | 'not' filter
  ;

fileName: STRING;
tagName : STRING;
attName : STRING;

STRING: CHAR+;
CHAR: ('a'..'z' | 'A'..'Z' | '0'..'9' | '_' | '.');
WS: [ \t\r\n]+ -> skip;