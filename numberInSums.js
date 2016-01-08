function somas(numero){
var possiveis = new Array();
var opcao;
for(var i = 1; i< numero; i++)
for(var j = 1; j< numero-i; j++)
for(var k = 1; k< numero-i-j; k++){
opcao = [i,j,k,numero-i-j-k].sort().join(',');
if(possiveis.indexOf(opcao) < 0)
  possiveis.push(opcao);
}
return possiveis;
}
