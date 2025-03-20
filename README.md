# CryptoTracker

CryptoTracker é uma aplicação Android que apresenta uma listagem de criptomoedas e o respetivo detalhe de cada moeda. Inclui um gráfico que representa a variação da moeda nas últimas 24 horas durante um período de 6 dias.

A aplicação é adaptativa e funciona tanto para dispositivos móveis como para tablets. Em tablets, a interface é otimizada para apresentar a listagem de criptomoedas de um lado e os detalhes da moeda do outro.

## Tecnologias Utilizadas
- **Kotlin**
- **Jetpack Compose**
- **Ktor Client** para requisições HTTP
- **Coroutines e Flows** para gestão assíncrona
- **ViewModel** para gestão de estado
- **Navigable List Detail Pane Scaffold** para navegação facilitada entre composables

## API Utilizada
A aplicação utiliza a API do [CoinCap](https://coincap.io/) para obter dados atualizados sobre criptomoedas.

## Configuração da Chave API
Para utilizar a API do CoinCap, é necessário obter uma chave de acesso:

1. Regista-te em [CoinCap](https://coincap.io/) e obtém a tua **API Key**.
2. No projeto, adiciona a tua chave API no ficheiro `local.properties` no seguinte formato:
   ```properties
   COINCAP_API="abcd12345..."
   ```
   (Inclui as aspas!)
3. O `build.gradle.kts` irá carregar automaticamente esta chave e disponibilizá-la no `BuildConfig`.

## Como Executar o Projeto
1. Clona este repositório:
   ```sh
   git clone https://github.com/teu-repo/cryptotracker.git
   ```
2. Abre o projeto no Android Studio.
3. Certifica-te de que tens o `local.properties` configurado conforme explicado acima.
4. Compila e executa a aplicação num emulador ou dispositivo físico.

## Contacto
Caso tenhas dúvidas ou sugestões, podes abrir uma _issue_ neste repositório ou entrar em contacto!

---

Agora está tudo pronto para acompanhares as tuas criptomoedas favoritas com o CryptoTracker! 🚀

