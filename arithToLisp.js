function operacaoEmLisp(str){
	str = str.toString();
	
	var wild = ['+','#','-','@','*','$','/','%'];

	var count;
	var esq;
	var dir;
	var operador;
	var operadorPosicao;
	
	//var prox = 1;
	
	var expressao;
	var retorno = "";
	
	var patt;
	
	if(str.search(/([\+\-\*\/])/g) > 0){
		if(str.search(/([\*\/])/g) > 0){
			expressao = str.split(/([\*\/])/g);
			for(var o = 0; o < expressao.length; ++o){
				patt = /[\/\*]/g;
				if(patt.test(expressao[o])){
					expressao.splice(expressao.indexOf(expressao[o]),1);
				}
			}
			count = expressao.length;
			
			operadorPosicao = str.search(/([\*\/])/);
			operador = str[operadorPosicao].toString();
		}else{
			expressao = str.split(/([\+\-])/g);
			count = expressao.length;
			
			operadorPosicao = str.search(/([\+\-])/);
			for(var o = 0; o < expressao.length; ++o){
				patt = /[\+\-]/g;
				if(patt.test(expressao[o])){
					expressao.splice(expressao.indexOf(expressao[o]),1);
				}
			}
			operador = str[operadorPosicao];
		};
	
		esq = expressao[0].split(/([\+\-\*\/])/g);
		esq = esq[esq.length - 1].toString();
			
		//for(var i = 1; i < expressao.length -1; ++i){
		//	if(isNaN(parseInt(expressao[prox])))
		//		prox++;
		//	else
		//		break;
		//}
		dir = expressao[1].split(/([\+\-\*\/])/g);
		dir = dir[0].toString();
		
		retorno = "["+wild[wild.indexOf(operador)+1]+" "+esq+" "+dir+"]";
		retorno = str.replace(esq+operador+dir,retorno);
	}else
		retorno = str;
	
	if(retorno.search(/([\+\-\*\/])/g) > 0)
		return operacaoEmLisp(retorno);
		//return retorno;
	else
		return retorno;
	
	
}

function solve(){
var p = document.getElementsByTagName("p")[1];
p = p.innerHTML ;
p = p.replace(/ /gi,'');

var prioridades = new Array();

var operacoes = new Array();
var tmp = "";
var prioridade = "";
while (p.match(/([\(])([0-9\+\-\*\/])*([\)])/g) != null){
	prioridades = p.match(/([\(])([0-9\+\-\*\/])*([\)])/g);
	
	for(var i = 0; i < prioridades.length; i++){
		prioridade = prioridades[i].toString().replace('(','').replace(')','');
		prioridade = operacaoEmLisp(prioridade);
		p = p.replace(prioridades[i],prioridade);
		//console.log(p);	
	}
}
	//console.log(p);
	p = operacaoEmLisp(p);
	//console.log(p);
	
	p = p.replace(/\#/gi,'+');
	p = p.replace(/\@/gi,'-');
	p = p.replace(/\$/gi,'*');
	p = p.replace(/\%/gi,'/');
	p = p.replace(/\[/gi,'(');
	p = p.replace(/\]/gi,')');

document.getElementsByClassName("solution")[0].value = p;
}
solve()
