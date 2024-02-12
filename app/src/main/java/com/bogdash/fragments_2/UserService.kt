package com.bogdash.fragments_2

class UserService {
    companion object {
        fun getUsers(): ArrayList<UserData> {
            return arrayListOf(
                UserData(
                    0,
                    "https://img.freepik.com/premium-photo/fashionable-portrait-of-anthropomorphic-cute-cat-dj-illustartion-granular-texturexa_739548-1336.jpg?w=826",
                    "Ivan",
                    "Ivanov",
                    "8 965 786 54 56"
                ),
                UserData(
                    1,
                    "https://img.freepik.com/premium-photo/british-shorthair-cat-isolated-close-up_191971-20639.jpg?w=826",
                    "Petya",
                    "Petrov",
                    "8 865 566 54 56"
                ),
                UserData(
                    2,
                    "https://img.freepik.com/free-photo/closeup-shot-of-two-brown-color-domestic-cats-sleeping_181624-56374.jpg?w=740&t=st=1707751007~exp=1707751607~hmac=e81e9cac8cf1ff28cc0eef9f16524246c1449050801227c6fa02c27aa0c138d5",
                    "Aleksey",
                    "Alekseev",
                    "8 965 456 54 32"
                ),
                UserData(
                    3,
                    "https://img.freepik.com/premium-photo/leopard-seal-on-beach-with-snow-in-antarctica_160321-6607.jpg?w=1380",
                    "Mark",
                    "Markov",
                    "8 123 786 54 32"
                ),
                UserData(
                    4,
                    "https://img.freepik.com/free-photo/cat-and-christmas-lights-cute-ginger-cat-lying-near-the-window-and-play-with-lights_8353-5954.jpg?w=1380&t=st=1707751906~exp=1707752506~hmac=53eb40e3addeef945717114bc0edcbe308ecfc5788cc678759356fd6d6140924",
                    "Ivan",
                    "Ivanov",
                    "8 965 786 54 56"
                ),
                UserData(
                    5,
                    "https://img.freepik.com/premium-photo/illustration-of-cute-pink-kitten-holding-bouquet-of-flowers-on-white-generative-ai_741672-2428.jpg?w=740",
                    "Petya",
                    "Petrov",
                    "8 865 566 54 56"
                ),
                UserData(
                    6,
                    "https://img.freepik.com/free-photo/view-of-adorable-3d-cats_23-2150473757.jpg?w=826&t=st=1707752022~exp=1707752622~hmac=0c406fd89be6f6c45d514aed2d2d5e17d352b5199e2c09595d9240d6538a7e1a",
                    "Aleksey",
                    "Alekseev",
                    "8 965 456 54 32"
                ),
                UserData(
                    7,
                    "https://img.freepik.com/free-photo/adorable-british-shorthair-kitty-with-monochrome-wall-behind-her_23-2148955093.jpg?w=1380&t=st=1707752072~exp=1707752672~hmac=98e1bfecfdefffef1a5117e4f108a2080e5a1da789633476d50f2b7796a8b68e",
                    "Mark",
                    "Markov",
                    "8 123 786 54 32"
                )
            )
        }
    }
}
