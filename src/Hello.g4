grammar  Hello;
//rule : 'hello' id;
//id   : STRING;

ap
  : 'doc("' fileName '")' '/'rp
  | 'doc("' fileName '")' '//'rp
  ;

rp
  : tagName | '*' | '.' | '..' | 'text()'|'@'attName
  | '(' rp ')' | rp '/' rp | rp '//' rp | rp '[' f ']' | rp ',' rp
  ;

f
  : rp | rp '=' rp | rp 'eq' rp | rp '==' rp | rp 'is' rp |
  | '(' f ')' | f 'and' f | f 'or' f | 'not' f
  ;

fileName: STRING;
tagName : STRING;
attName : STRING;

STRING: CHAR+;
CHAR: ('a'..'z' | 'A'..'Z' | '0'..'9' | '_' | '.');
WS: [ \t\r\n]+ -> skip;
