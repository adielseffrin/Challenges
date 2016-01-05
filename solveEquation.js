/*
* To solve in a time less than 5 seconds, works when there are 3 or less different variables.
* With more variables, time still being an issue.
*/

function equate(){
	var debug = false;
	var detail = false;
	
	var text = document.getElementsByTagName('pre')[0].innerHTML;
	var letras = text.match(/[a-z]/g).join('');
	
	if(String(text[0]) != '-') text = '+'+text;
	var sides= text.split(/[\=]/);
	if(sides[1][0] != '-') sides[1] = '+'+sides[1];
	var newEq = sides[0]+sides[1].replace(/\-/g,'@').replace(/\+/g,'-').replace(/\@/g,'+');
	var signs = newEq.match(/[\-\+]/g); //1 - n
	signs = signs.filter(function(e){return e}); 
	var elems = newEq.split(/[\-\+]/g); //0 - n
	elems = elems.filter(function(e){return e}); 
	var exps = [0,0,0,0,0,0];
	//var exps = [0,1,4,0,0,8];

	var patt = [0,0,0,0,0,0];
	var totalLetras = 0;
 	if(text.indexOf('a') > 0){ patt[0] = 1; totalLetras++;}
	if(text.indexOf('b') > 0){ patt[1] = 1; totalLetras++;}
	if(text.indexOf('c') > 0){ patt[2] = 1; totalLetras++;}
	if(text.indexOf('d') > 0){ patt[3] = 1; totalLetras++;}
	if(text.indexOf('e') > 0){ patt[4] = 1; totalLetras++;}
	if(text.indexOf('f') > 0){ patt[5] = 1; totalLetras++;}
	
	var solv = "";
	var pos = null;
	var partes;
	
	var limit = Math.pow(10,totalLetras);
	if(debug) limit = Math.pow(10,0);
	
	for(var loop = 0; loop < limit; loop++){
		solv = "";
		for(var i = 0; i < elems.length; i++){
			partes = "";
			pos = null;
			if(!!elems[i].match(/[a-z]/)) pos = elems[i].match(/[a-z]/)[0];
			if(!debug){
				if(!!pos){
					partes = elems[i].split('*');
					solv += signs[i]+partes[0]+"*"+Math.pow(exps[toPos(partes[1].split('_')[0])],partes[1].split('_')[1]);
				}else
					solv += signs[i]+elems[i];
			}else
				solv += signs[i]+elems[i];
		}
		
		if(debug){
			console.log(solv.replace(/\_/g,'^'));
		}
		
		if(!debug){
			if(eval(solv.replace(/\_/g,'^')) != 0){
				exps = incr(exps,exps.length,patt);
			}else{
				console.log('achei');
				break;
			}
		}
	}
	
	if(detail)
		console.log(exps);
	
	
	var ret1 = toNum(letras,exps,patt);
	
	var str2 = String(toNum(sides[0].replace(/\_/g,'^'),exps,patt)); //todo: arrumar pow(a,b)
	var matches = toNum(sides[0].replace(/\_/g,'^'),exps,patt).match(/[0-9]\^[0-9]/g);
	
	for(var j = 0; j < matches.length; j++){
		str2 = str2.replace(matches[j],Math.pow(matches[j].split('^')[0],matches[j].split('^')[1]));
	}
	var ret2 = String(eval(str2));
	if(detail){
		console.log(str2);
	}
	
	console.log(letras);
	console.log(ret1);
	console.log(ret2);
	window.location.href = "http://www.rankk.org/challenges/simultaneously.py?solution="+ret1 + ret2;
}



function incr(arr,pos,patt){
	
	if(pos > 0 ){
		if(arr[pos-1] < 9 && patt[pos-1] == 1) arr[pos-1]++;
		else{
			arr[pos-1] = 0;
			arr = incr(arr, pos - 1,patt);
		}
		//console.log(arr.join(','));
		return arr;
	}else
		return arr;
}

function toPos(letter){
	switch(letter){
	case 'a':
		return 0;
		break;
	case 'b':
		return 1;
		break;
	case 'c':
		return 2;
		break;
	case 'd':
		return 3;
		break;
	case 'e':
		return 4;
		break;
	case 'f':
		return 5;
		break;
	
	}
}

function toNum(string, values, patt){
	var letras = ['a','b','c','d','e','f'];
	var str;
	var re;
	
	for(var i = 0; i < patt.length; i++){
		if(!!patt[i]){
			str = letras[i];
			re = new RegExp(str, "g");
			string = string.replace(re,values[i]);
		}
	}
	return string;

}

equate();
