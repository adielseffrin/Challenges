function numberToText(nro){
retorno = '';
var str = nro.toString();
	switch (str.length) {
		case 1:
			retorno += unit0(str[0]);
			break;
		case 2:
			if(parseInt(str[0]) > 1){
				retorno += dezen(str[0])+unit(str[1]);
			}else{
				retorno += dezenUnit(str[0]+str[1]);
			}
			break;
		case 3:
			retorno = cent(str[0])
			if(parseInt(str[1]) > 1){
				retorno += "and"+dezen(str[1])+unit(str[2]);			
			}else{
				if(parseInt(str[1]) == 1){
					retorno += "and"+dezenUnit(str[1]+str[2]);
				}else{
					if(parseInt(str[2]) != 0)
						retorno += "and"+unit(str[2]);
				}
			}
			
			break;
	}
	return retorno;
}

function unit(nro){
	switch (nro){
		case "0":
			return "";
			break;
		case "1":
			return "one";
			break;
		case "2":
			return "two";
			break;
		case "3":
			return "three";
			break;
		case "4":
			return "four";
			break;
		case "5":
			return "five";
			break;
		case "6":
			return "six";
			break;
		case "7":
			return "seven";
			break;
		case "8":
			return "eight";
			break;
		case "9":
			return "nine";			
			break;
	}
}

function unit0(nro){
	switch (nro){
		case "0":
			return "zero";
			break;
		case "1":
			return "one";
			break;
		case "2":
			return "two";
			break;
		case "3":
			return "three";
			break;
		case "4":
			return "four";
			break;
		case "5":
			return "five";
			break;
		case "6":
			return "six";
			break;
		case "7":
			return "seven";
			break;
		case "8":
			return "eight";
			break;
		case "9":
			return "nine";	
			break;			
	}
}

function dezenUnit(nro){
	switch (nro){
		case "10":
			return "ten";
			break;
		case "11":
			return "eleven";
			break;
		case "12":
			return "twelve";
			break;
		case "13":
			return "thirteen";
			break;
		case "14":
			return "fourteen";
			break;
		case "15":
			return "fifteen";
			break;
		case "16":
			return "sixteen";
			break;
		case "17":
			return "seventeen";
			break;
		case "18":
			return "eighteen";
			break;
		case "19":
			return "nineteen";	
			break;			
	}
}

function dezen(nro){
	switch (nro){
		case "2":
			return "twenty";
			break;
		case "3":
			return "thirty";
			break;
		case "4":
			return "forty";
			break;
		case "5":
			return "fifty";
			break;
		case "6":
			return "sixty";
			break;
		case "7":
			return "seventy";
			break;
		case "8":
			return "eighty";
			break;
		case "9":
			return "ninety";	
			break;
	}
}

function cent(nro){
	var str = '';
	switch (nro){
		case "0":
			str = "zero";
			break;
		case "1":
			str = "one";
			break;
		case "2":
			str = "two";
			break;
		case "3":
			str = "three";
			break;
		case "4":
			str = "four";
			break;
		case "5":
			str = "five";
			break;
		case "6":
			str = "six";
			break;
		case "7":
			str = "seven";
			break;
		case "8":
			str = "eight";
			break;
		case "9":
			str = "nine";			
			break;
	}
	return str+"hundred";
}

var arr = document.getElementsByTagName('pre')[0].innerHTML.match(/(\d)+/g);
var sum = 0;
var str = '';
for(var i = 0; i < arr.length; ++i){
	sum += parseInt(numberToText(arr[i].toString()).length);
}

var position = parseInt(document.getElementsByTagName('p')[1].innerHTML.match(/(\d)+/g)[0]);
var sufix = arr[parseInt(position-1)];

window.location.href = 'http://www.rankk.org/challenges/convert-and-count.py?solution='+sum.toString()+sufix.toString();
