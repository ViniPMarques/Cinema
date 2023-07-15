<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Visualizar Filme</title>
    <style>
        html, body {
            height: 100%;
        }

        html {
            display: table;
            margin: auto;
        }

        body {
            display: table-cell;
            vertical-align: middle;
            font-family: Arial, sans-serif;
            background-color: #121212;
            margin: 0;
            padding: 0;
        }

        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .video-wrapper {
            max-width: 800px;
            margin: 0 auto;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .video-container {
            position: relative;
            overflow: hidden;
            padding-top: 56.25%; /* Proporção de 16:9 (divida a altura pelo tamanho da largura) */
        }

        .video-container iframe {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
        }
        .back-link {
            display: block;
            margin: 10px;
            text-align: center;
            color: #f9f9f9;
        }

    </style>
</head>
<body>
<a href="${pageContext.request.contextPath}/principal" class="back-link">Voltar</a>
<div id="player"></div>

<script>
    var tag = document.createElement('script');
    tag.src = "https://www.youtube.com/iframe_api";
    var firstScriptTag = document.getElementsByTagName('script')[0];
    firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

    var player;
    function onYouTubeIframeAPIReady() {
        player = new YT.Player('player', {
            height: '720',
            width: '1680',
            videoId: 'M7lc1UVf-VE',
            playerVars: { 'controls': 0 },
            events: {
                'onReady': onPlayerReady,
                'onStateChange': onPlayerStateChange
            }
        });
    }

    function onPlayerReady(event) {
        event.target.setVolume(75);
        //event.target.playVideo();
    }

    var done = false;
    function onPlayerStateChange(event) {
        if (event.data == YT.PlayerState.PLAYING && !done) {
            done = true;
        }
    }
    function stopVideo() {
        player.stopVideo();
    }
</script>
</body>
</html>

