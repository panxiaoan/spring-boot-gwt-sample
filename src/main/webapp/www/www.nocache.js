function www(){var Q='bootstrap',R='begin',S='gwt.codesvr.www=',T='gwt.codesvr=',U='www',V='startup',W='DUMMY',X=0,Y=1,Z='iframe',$='javascript:""',_='position:absolute; width:0; height:0; border:none; left: -1000px;',ab=' top: -1000px;',bb='CSS1Compat',cb='<!doctype html>',db='',eb='<html><head><\/head><body><\/body><\/html>',fb='undefined',gb='readystatechange',hb=10,ib='Chrome',jb='eval("',kb='");',lb='script',mb='javascript',nb='moduleStartup',ob='moduleRequested',pb='Failed to load ',qb='head',rb='meta',sb='name',tb='www::',ub='::',vb='gwt:property',wb='content',xb='=',yb='gwt:onPropertyErrorFn',zb='Bad handler "',Ab='" for "gwt:onPropertyErrorFn"',Bb='gwt:onLoadErrorFn',Cb='" for "gwt:onLoadErrorFn"',Db='#',Eb='?',Fb='/',Gb='img',Hb='clear.cache.gif',Ib='baseUrl',Jb='www.nocache.js',Kb='base',Lb='//',Mb='locale',Nb='default',Ob='locale=',Pb=7,Qb='&',Rb='__gwt_Locale',Sb='_',Tb='Unexpected exception in locale detection, using default: ',Ub='user.agent',Vb='webkit',Wb='safari',Xb='msie',Yb=11,Zb='ie10',$b=9,_b='ie9',ac=8,bc='ie8',cc='gecko',dc='gecko1_8',ec=2,fc=3,gc=4,hc='selectingPermutation',ic='www.devmode.js',jc='15FD62152B28D48DCB85E5BCA4E70B2E',kc='41102CC7A0328516D3B71005704D0689',lc='4388206C7F06BDB38DB79C34DB9BD6F5',mc='zh_CN',nc='5D58636FE03FBC0BDA96F2DDEBED9ADC',oc='64738BB73587F31B55993018D6489EC4',pc='7CEA79196335B0EAD1465D91E8F36187',qc='82784610BF7E9CD8213A739E3E60363B',rc='E1FBAE08978126A0E55E90B46C777D67',sc='EBE716845DB8E7274CE814CA73690D4C',tc='FC03F07E723BEFC39359B7FED1F265A5',uc=':',vc='.cache.js',wc='loadExternalRefs',xc='end',yc='http:',zc='file:',Ac='_gwt_dummy_',Bc='__gwtDevModeHook:www',Cc='Ignoring non-whitelisted Dev Mode URL: ',Dc=':moduleBase';var q=window;var r=document;t(Q,R);function s(){var a=q.location.search;return a.indexOf(S)!=-1||a.indexOf(T)!=-1}
function t(a,b){if(q.__gwtStatsEvent){q.__gwtStatsEvent({moduleName:U,sessionId:q.__gwtStatsSessionId,subSystem:V,evtGroup:a,millis:(new Date).getTime(),type:b})}}
www.__sendStats=t;www.__moduleName=U;www.__errFn=null;www.__moduleBase=W;www.__softPermutationId=X;www.__computePropValue=null;www.__getPropMap=null;www.__installRunAsyncCode=function(){};www.__gwtStartLoadingFragment=function(){return null};www.__gwt_isKnownPropertyValue=function(){return false};www.__gwt_getMetaProperty=function(){return null};var u=null;var v=q.__gwt_activeModules=q.__gwt_activeModules||{};v[U]={moduleName:U};www.__moduleStartupDone=function(e){var f=v[U].bindings;v[U].bindings=function(){var a=f?f():{};var b=e[www.__softPermutationId];for(var c=X;c<b.length;c++){var d=b[c];a[d[X]]=d[Y]}return a}};var w;function A(){B();return w}
function B(){if(w){return}var a=r.createElement(Z);a.src=$;a.id=U;a.style.cssText=_+ab;a.tabIndex=-1;r.body.appendChild(a);w=a.contentDocument;if(!w){w=a.contentWindow.document}w.open();var b=document.compatMode==bb?cb:db;w.write(b+eb);w.close()}
function C(k){function l(a){function b(){if(typeof r.readyState==fb){return typeof r.body!=fb&&r.body!=null}return /loaded|complete/.test(r.readyState)}
var c=b();if(c){a();return}function d(){if(!c){if(!b()){return}c=true;a();if(r.removeEventListener){r.removeEventListener(gb,d,false)}if(e){clearInterval(e)}}}
if(r.addEventListener){r.addEventListener(gb,d,false)}var e=setInterval(function(){d()},hb)}
function m(c){function d(a,b){a.removeChild(b)}
var e=A();var f=e.body;var g;if(navigator.userAgent.indexOf(ib)>-1&&window.JSON){var h=e.createDocumentFragment();h.appendChild(e.createTextNode(jb));for(var i=X;i<c.length;i++){var j=window.JSON.stringify(c[i]);h.appendChild(e.createTextNode(j.substring(Y,j.length-Y)))}h.appendChild(e.createTextNode(kb));g=e.createElement(lb);g.language=mb;g.appendChild(h);f.appendChild(g);d(f,g)}else{for(var i=X;i<c.length;i++){g=e.createElement(lb);g.language=mb;g.text=c[i];f.appendChild(g);d(f,g)}}}
www.onScriptDownloaded=function(a){l(function(){m(a)})};t(nb,ob);var n=r.createElement(lb);n.src=k;if(www.__errFn){n.onerror=function(){www.__errFn(U,new Error(pb+code))}}r.getElementsByTagName(qb)[X].appendChild(n)}
www.__startLoadingFragment=function(a){return G(a)};www.__installRunAsyncCode=function(a){var b=A();var c=b.body;var d=b.createElement(lb);d.language=mb;d.text=a;c.appendChild(d);c.removeChild(d)};function D(){var c={};var d;var e;var f=r.getElementsByTagName(rb);for(var g=X,h=f.length;g<h;++g){var i=f[g],j=i.getAttribute(sb),k;if(j){j=j.replace(tb,db);if(j.indexOf(ub)>=X){continue}if(j==vb){k=i.getAttribute(wb);if(k){var l,m=k.indexOf(xb);if(m>=X){j=k.substring(X,m);l=k.substring(m+Y)}else{j=k;l=db}c[j]=l}}else if(j==yb){k=i.getAttribute(wb);if(k){try{d=eval(k)}catch(a){alert(zb+k+Ab)}}}else if(j==Bb){k=i.getAttribute(wb);if(k){try{e=eval(k)}catch(a){alert(zb+k+Cb)}}}}}__gwt_getMetaProperty=function(a){var b=c[a];return b==null?null:b};u=d;www.__errFn=e}
function F(){function e(a){var b=a.lastIndexOf(Db);if(b==-1){b=a.length}var c=a.indexOf(Eb);if(c==-1){c=a.length}var d=a.lastIndexOf(Fb,Math.min(c,b));return d>=X?a.substring(X,d+Y):db}
function f(a){if(a.match(/^\w+:\/\//)){}else{var b=r.createElement(Gb);b.src=a+Hb;a=e(b.src)}return a}
function g(){var a=__gwt_getMetaProperty(Ib);if(a!=null){return a}return db}
function h(){var a=r.getElementsByTagName(lb);for(var b=X;b<a.length;++b){if(a[b].src.indexOf(Jb)!=-1){return e(a[b].src)}}return db}
function i(){var a=r.getElementsByTagName(Kb);if(a.length>X){return a[a.length-Y].href}return db}
function j(){var a=r.location;return a.href==a.protocol+Lb+a.host+a.pathname+a.search+a.hash}
var k=g();if(k==db){k=h()}if(k==db){k=i()}if(k==db&&j()){k=e(r.location.href)}k=f(k);return k}
function G(a){if(a.match(/^\//)){return a}if(a.match(/^[a-zA-Z]+:\/\//)){return a}return www.__moduleBase+a}
function H(){var i=[];var j=X;function k(a,b){var c=i;for(var d=X,e=a.length-Y;d<e;++d){c=c[a[d]]||(c[a[d]]=[])}c[a[e]]=b}
var l=[];var m=[];function n(a){var b=m[a](),c=l[a];if(b in c){return b}var d=[];for(var e in c){d[c[e]]=e}if(u){u(a,d,b)}throw null}
m[Mb]=function(){var b=null;var c=Nb;try{if(!b){var d=location.search;var e=d.indexOf(Ob);if(e>=X){var f=d.substring(e+Pb);var g=d.indexOf(Qb,e);if(g<X){g=d.length}b=d.substring(e+Pb,g)}}if(!b){b=__gwt_getMetaProperty(Mb)}if(!b){b=q[Rb]}if(b){c=b}while(b&&!__gwt_isKnownPropertyValue(Mb,b)){var h=b.lastIndexOf(Sb);if(h<X){b=null;break}b=b.substring(X,h)}}catch(a){alert(Tb+a)}q[Rb]=c;return b||Nb};l[Mb]={'default':X,'zh_CN':Y};m[Ub]=function(){var a=navigator.userAgent.toLowerCase();var b=r.documentMode;if(function(){return a.indexOf(Vb)!=-1}())return Wb;if(function(){return a.indexOf(Xb)!=-1&&(b>=hb&&b<Yb)}())return Zb;if(function(){return a.indexOf(Xb)!=-1&&(b>=$b&&b<Yb)}())return _b;if(function(){return a.indexOf(Xb)!=-1&&(b>=ac&&b<Yb)}())return bc;if(function(){return a.indexOf(cc)!=-1||b>=Yb}())return dc;return db};l[Ub]={'gecko1_8':X,'ie10':Y,'ie8':ec,'ie9':fc,'safari':gc};__gwt_isKnownPropertyValue=function(a,b){return b in l[a]};www.__getPropMap=function(){var a={};for(var b in l){if(l.hasOwnProperty(b)){a[b]=n(b)}}return a};www.__computePropValue=n;q.__gwt_activeModules[U].bindings=www.__getPropMap;t(Q,hc);if(s()){return G(ic)}var o;try{k([Nb,Zb],jc);k([Nb,dc],kc);k([Nb,_b],lc);k([mc,bc],nc);k([Nb,Wb],oc);k([mc,_b],pc);k([mc,Zb],qc);k([Nb,bc],rc);k([mc,Wb],sc);k([mc,dc],tc);o=i[n(Mb)][n(Ub)];var p=o.indexOf(uc);if(p!=-1){j=parseInt(o.substring(p+Y),hb);o=o.substring(X,p)}}catch(a){}www.__softPermutationId=j;return G(o+vc)}
function I(){if(!q.__gwt_stylesLoaded){q.__gwt_stylesLoaded={}}t(wc,R);t(wc,xc)}
D();www.__moduleBase=F();v[U].moduleBase=www.__moduleBase;var J=H();if(q){var K=!!(q.location.protocol==yc||q.location.protocol==zc);q.__gwt_activeModules[U].canRedirect=K;function L(){var b=Ac;try{q.sessionStorage.setItem(b,b);q.sessionStorage.removeItem(b);return true}catch(a){return false}}
if(K&&L()){var M=Bc;var N=q.sessionStorage[M];if(!/^http:\/\/(localhost|127\.0\.0\.1)(:\d+)?\/.*$/.test(N)){if(N&&(window.console&&console.log)){console.log(Cc+N)}N=db}if(N&&!q[M]){q[M]=true;q[M+Dc]=F();var O=r.createElement(lb);O.src=N;var P=r.getElementsByTagName(qb)[X];P.insertBefore(O,P.firstElementChild||P.children[X]);return false}}}I();t(Q,xc);C(J);return true}
www.succeeded=www();