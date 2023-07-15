<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Visualizar Filme</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
            background-image: url('https://e0.pxfuel.com/wallpapers/463/120/desktop-wallpaper-movie-theatre.jpg');
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            filter: brightness(50%);
        }

        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        /*.video-wrapper {*/
        /*    max-width: 800px;*/
        /*    margin: 0 auto;*/
        /*    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);*/
        /*}*/
        /*.video-container {*/
        /*    position: relative;*/
        /*    overflow: hidden;*/
        /*    padding-top: 56.25%; !* Proporção de 16:9 (divida a altura pelo tamanho da largura) *!*/
        /*}*/
        /*.video-container iframe {*/
        /*    position: absolute;*/
        /*    top: 0;*/
        /*    left: 0;*/
        /*    width: 100%;*/
        /*    height: 100%;*/
        /*}*/

        .back-link {
            display: inline-block;
            margin: 10px;
            padding: 10px 20px;
            font-size: 22px;
            color: #fff;
            background-color: #f0544f;
            border: none;
            border-radius: 30px;
            transition: background-color 0.3s ease;
            text-decoration: none;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
        }
        .film-link {
            display: inline-block;
            margin: 10px;
            padding: 10px 20px;
            font-size: 22px;
            color: #fff;
            background-color: #00A86B;
            border: none;
            border-radius: 30px;
            transition: background-color 0.3s ease;
            text-decoration: none;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
        }

        .back-link:hover {
            background-color: #d9433f;
        }
        .film-link:hover {
            background-color: #01796F;
        }
    </style>
</head>
<body>
<div class="container">
    <a href="${pageContext.request.contextPath}/principal" class="back-link">Voltar</a>
    <a href="${linkFilm}" target="_blank" class="film-link">Ir Para o Link do Filme</a>
</div>

<%-- Caso o youtube permitisse acesso de localhost por sua API, o código abaixo puxaria--%>
<%-- o primeiro link da pesquisa no youtube e mostraria na tela--%>

<%--<script>--%>
<%--    // Obtém o título do filme do parâmetro GET--%>
<%--    var tituloFilme = "${tituloFilme}";--%>
<%--    console.log(tituloFilme);--%>
<%--    var searchTerm = tituloFilme + ' Movie Trailer';--%>
<%--    // Chama a função para procurar o vídeo no YouTube--%>
<%--    searchYouTubeVideo(searchTerm);--%>
<%--    console.log(searchTerm);--%>
<%--    function searchYouTubeVideo(searchTerm) {--%>
<%--        var apiKey = 'AIzaSyDPEsgKg-0dT23e7tK4Ny3D0YGzylGNh8w';--%>
<%--        var apiUrl = 'https://www.googleapis.com/youtube/v3/search?part=snippet&q=' + encodeURIComponent(searchTerm) + '&key=' + apiKey;--%>
<%--        fetch(apiUrl)--%>
<%--            .then(response => response.json())--%>
<%--            .then(data => {--%>
<%--                // Obtém o ID do vídeo da resposta da API--%>
<%--                var videoId = data.items[0].id.videoId;--%>
<%--                if (videoId) {--%>
<%--                    // Cria o player do YouTube com o ID do vídeo obtido--%>
<%--                    createYouTubePlayer(videoId);--%>
<%--                } else {--%>
<%--                    console.log('Nenhum vídeo encontrado para o termo de pesquisa: ' + searchTerm);--%>
<%--                }--%>
<%--            })--%>
<%--            .catch(error => {--%>
<%--                console.error('Ocorreu um erro ao realizar a pesquisa no YouTube:', error);--%>
<%--            });--%>
<%--        // URL da pesquisa do YouTube--%>
<%--        var searchUrl = 'https://www.youtube.com/results?search_query=' + encodeURIComponent(searchTerm);--%>
<%--    }--%>
<%--    // Função para extrair o ID do vídeo da página--%>
<%--    function extractVideoId(html) {--%>
<%--        // Expressão regular para encontrar o ID do vídeo na página--%>
<%--        var regex = /"videoId":"([^"]+)"/;--%>
<%--        var match = html.match(regex);--%>
<%--        if (match && match[1]) {--%>
<%--            return match[1];--%>
<%--        } else {--%>
<%--            return null;--%>
<%--        }--%>
<%--    }--%>
<%--    // Função para criar o player do YouTube--%>
<%--    function createYouTubePlayer(videoId) {--%>
<%--        var tag = document.createElement('script');--%>
<%--        tag.src = "https://www.youtube.com/iframe_api";--%>
<%--        var firstScriptTag = document.getElementsByTagName('script')[0];--%>
<%--        firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);--%>
<%--    }--%>
<%--    // Função chamada quando a API do YouTube é carregada--%>
<%--    function onYouTubeIframeAPIReady() {--%>
<%--        var player = new YT.Player('player', {--%>
<%--            height: '720',--%>
<%--            width: '1280',--%>
<%--            playerVars: { 'controls': 0 },--%>
<%--            events: {--%>
<%--                'onReady': onPlayerReady,--%>
<%--                'onStateChange': onPlayerStateChange--%>
<%--            }--%>
<%--        });--%>
<%--        function onPlayerReady(event) {--%>
<%--            event.target.setVolume(75);--%>
<%--            //event.target.playVideo();--%>
<%--        }--%>
<%--        var done = false;--%>
<%--        function onPlayerStateChange(event) {--%>
<%--            if (event.data == YT.PlayerState.PLAYING && !done) {--%>
<%--                done = true;--%>
<%--            }--%>
<%--        }--%>
<%--        function stopVideo() {--%>
<%--            player.stopVideo();--%>
<%--        }--%>
<%--    }--%>

<%--</script>--%>
</body>
</html>


