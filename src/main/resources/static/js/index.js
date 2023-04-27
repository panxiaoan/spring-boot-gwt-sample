// SmartGWT Core
var iscVersion = "v13p230421";

document.write('<script src="www/sc/modules/ISC_Core.js?version=' + iscVersion + '"></script>');

// SmartGWT UI Components
document.write('<script src="www/sc/modules/ISC_Foundation.js?version=' + iscVersion + '"></script>');
document.write('<script src="www/sc/modules/ISC_Containers.js?version=' + iscVersion + '"></script>');
document.write('<script src="www/sc/modules/ISC_Grids.js?version=' + iscVersion + '"></script>');
document.write('<script src="www/sc/modules/ISC_Forms.js?version=' + iscVersion + '"></script>');
document.write('<script src="www/sc/modules/ISC_RichTextEditor.js?version=' + iscVersion + '"></script>');

// SmartGWT DataBinding Components
document.write('<script src="www/sc/modules/ISC_DataBinding.js?version=?version=' + iscVersion + '"></script>');
document.write('<script src="www/sc/modules/ISC_Calendar.js?version=' + iscVersion + '"></script>');
document.write('<script src="www/sc/modules/ISC_Drawing.js?version=' + iscVersion + '"></script>');

// SmartGWT Skin
var currentSkin = readCookie('smartgwt_skin');
if (currentSkin == null) {
    // currentSkin = isc.Browser.defaultSkin;
//    currentSkin = "Stratus";
    currentSkin = "Default";
}

if (currentSkin == "Default") {
    document.write('<script src="theme/' + currentSkin + '/load_skin.js?version=' + iscVersion + '"></script>');
} else {
    document.write('<script src="www/sc/skins/' + currentSkin + '/load_skin.js?version=' + iscVersion + '"></script>');
}

// Font ICON
var fontAwesomeVersion = "5.1.1";
document.write('<link type="text/css" rel="stylesheet" href="fontawesome/css/all.min.css?version=' + fontAwesomeVersion + '"/>');


function readCookie(name) {
	var nameEQ = name + "=";
	var ca = document.cookie.split(';');
	for (var i = 0; i < ca.length; i++) {
		var c = ca[i];
		while (c.charAt(0) == ' ')
			c = c.substring(1, c.length);
		if (c.indexOf(nameEQ) == 0)
			return c.substring(nameEQ.length, c.length);
	}
	return null;
}

function setCookie(cname, cvalue, exdays) {
	var d = new Date();
	d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
	var expires = "expires=" + d.toGMTString();
	document.cookie = cname + "=" + cvalue + ";" + expires;
}

function launchFullScreen() {
	var element = document.documentElement;
	if (element.requestFullscreen) {
		element.requestFullscreen();
	} else if (element.mozRequestFullScreen) {
		element.mozRequestFullScreen();
	} else if (element.webkitRequestFullscreen) {
		element.webkitRequestFullscreen();
	} else if (element.msRequestFullscreen) {
		element.msRequestFullscreen();
	}
}

function exitFullScreen() {
	if (document.exitFullscreen) {
		document.exitFullscreen();
	} else if (document.mozCancelFullScreen) {
		document.mozCancelFullScreen();
	} else if (document.webkitExitFullscreen) {
		document.webkitExitFullscreen();
	} else if (document.msExitFullscreen) {
		document.msExitFullscreen();
	}
}