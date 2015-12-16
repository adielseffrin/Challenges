function httpGet(theUrl)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
    xmlHttp.send( null );
    var retorno =  xmlHttp.responseText.match(/(<p>)([\w\ ])+(<\/p>)/g)[0].match(/\d+/g)[0];
	if(retorno != "")
		httpGet("http://www.rankk.org/challenges/linked-list.py?solution="+retorno);
	else
		return theUrl;
}
