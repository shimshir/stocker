<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>

</head>
<body>
<div id="fb-root"></div>
<script>
    (function (d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s);
        js.id = id;
        js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.0";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));

    !function (d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0], p = /^http:/.test(d.location) ? 'http' : 'https';
        if (!d.getElementById(id)) {
            js = d.createElement(s);
            js.id = id;
            js.src = p + '://platform.twitter.com/widgets.js';
            fjs.parentNode.insertBefore(js, fjs);
        }
    }(document, 'script', 'twitter-wjs');


</script>

<h1>${message}</h1>

<a href="/stocker/company">Add a Company</a>
<br>
<br>

<div class="fb-like"
     data-href="https://www.facebook.com/pages/Misty-Mountains/107857562570890"
     data-layout="standard" data-action="like" data-show-faces="true" data-share="false"></div>
<br>
<br>

<div class="fb-share-button" data-href="https://www.youtube.com/watch?v=BEm0AjTbsac" data-type="button_count"></div>
<br>
<br>
<a href="https://twitter.com/share" class="twitter-share-button" data-url="https://www.youtube.com/watch?v=BEm0AjTbsac"
   data-text="The song from The Hobbit">Tweet</a>
<br>
<br>
<a href="http://www.linkedin.com/shareArticle?mini=true&amp;url=https://www.youtube.com/watch?v=BEm0AjTbsac&amp;title=Misty Mountains&amp;summary=The song from The Hobbit"
   onclick="window.open(this.href, 'mywin','width=602,height=450,toolbar=0,resizable=1'); return false;">
    <img alt="" src="http://4.bp.blogspot.com/-sceM6ThPXcY/Uf7FLbTBQeI/AAAAAAAACR0/ZpolEsgBUnE/s1600/in.png"
         width="32" height="32"/>
</a>
<br>
<br>

<div class="g-plus" data-action="share" data-annotation="bubble"
     data-href="https://www.youtube.com/watch?v=BEm0AjTbsac"></div>

<script type="text/javascript">
    (function () {
        var po = document.createElement('script');
        po.type = 'text/javascript';
        po.async = true;
        po.src = 'https://apis.google.com/js/platform.js';
        var s = document.getElementsByTagName('script')[0];
        s.parentNode.insertBefore(po, s);
    })();
</script>

</body>
</html>
