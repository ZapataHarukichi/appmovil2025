package com.example.appmovil2025.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appmovil2025.R
import com.example.appmovil2025.model.Ponente
import org.json.JSONArray
import org.json.JSONObject
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonArr = JSONArray(
            "[\n" +
                    "            {\n" +
                    "                'biography' : 'Cesar Pereda, creativo y content creator del equipo de IntegraTics, transforma las ideas en historias inspiradoras y contenidos innovadores que impactan al mundo para generar gracias, no solo likes, de nada sirve tu talento si no estas haciendo algo con el, de nada sirven tus habilidades si no tienes ideas para fusionarlas.',\n" +
                    "                'category' : 5,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/1015273976438902784/T0gZSbTP_400x400.jpg',\n" +
                    "                'jobtitle' : 'Content Creator',\n" +
                    "                'name' : 'Cesar Pereda',\n" +
                    "                'twitter' : 'Peredacesar',\n" +
                    "                'workplace' : 'IntegraTics'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Soy Win. Greñudo, flaco y ojeroso. Hago fotografía los domingos. Head of production at @integratics',\n" +
                    "                'category' : 12,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/902939605221199872/eJypBkO__400x400.jpg',\n" +
                    "                'jobtitle' : 'Head of Production',\n" +
                    "                'name' : 'Ludwin Cuevas',\n" +
                    "                'twitter' : 'winiberto',\n" +
                    "                'workplace' : 'IntegraTics'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'CEO y Fundador de Capptu el banco de fotografías que las conecta con las marcas y que además que fue reconocido por la revista Forbes México como promesa de negocios del 2018.',\n" +
                    "                'category' : 10,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/1042801434989879296/Dya62rEB_400x400.jpg',\n" +
                    "                'jobtitle' : 'Founder & CEO',\n" +
                    "                'name' : 'Manuel Villegas',\n" +
                    "                'twitter' : 'manvillegasmx',\n" +
                    "                'workplace' : 'Capptu'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Líder del equipo de Growth en IntegraTics y Google Doc Expert en Marketing, especialista en análisis de datos, presupuesto y proyecciones de Startups, lo que lo ha llevado a ser un gran conferencista a nivel mundial. Recuerden si estamos haciendo algo y no estamos aprendiendo de ello, no sirve de nada.',\n" +
                    "                'category' : 9,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/1128429578647736321/5ZwuI5_Q_400x400.jpg',\n" +
                    "                'jobtitle' : 'Head of Growth',\n" +
                    "                'name' : 'Juan Pablo Rojas',\n" +
                    "                'twitter' : 'UnMalNick',\n" +
                    "                'workplace' : 'IntegraTics'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Pablo Villanueva es Google Developer Expert, Co-fundador y Chief Technology en Metix Medical. Es un gran facilitador de equipos con metodologías ágiles y reconocido profesor de IntegraTics. SRE en Globant. Google Developer Expert y Google Cloud Authorized Trainer. Organizador en GDG Cloud MX.',\n" +
                    "                'category' : 6,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/1225834733549965312/JixgS3m__400x400.jpg',\n" +
                    "                'jobtitle' : 'Co-founder & CTO',\n" +
                    "                'name' : 'Pablo Villanueva',\n" +
                    "                'twitter' : 'pablovillamx',\n" +
                    "                'workplace' : 'Metix'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Co-fundadora de Fitco, donde estamos ayudando a Fitness Boutiques a crecer a través de la tecnología. Trabajando y apasionado por el crecimiento de SaaS a través de ventas, inbound marketing y asociaciones.',\n" +
                    "                'category' : 11,\n" +
                    "                'image' : 'https://media-exp2.licdn.com/dms/image/C4E03AQE3a2dbco8Niw/profile-displayphoto-shrink_800_800/0?e=1585180800&v=beta&t=Pb0KFPrtO-FR2zUlk_rPSPmZU_LAdpowWAt9s2LgzKA',\n" +
                    "                'jobtitle' : 'CEO',\n" +
                    "                'name' : 'Andrea Baba',\n" +
                    "                'twitter' : 'butiqlive',\n" +
                    "                'workplace' : 'FITco'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Claudia Sosa, diseñadora industrial y líder de CX Design de BBVA. Su fuerte, aplicar innovación en el diseño de productos y servicios. con tecnologías especializadas en mejorar la experiencia del cliente.',\n" +
                    "                'category' : 4,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/770787948719505408/KSvKmi9y_400x400.jpg',\n" +
                    "                'jobtitle' : 'Head of CX Design',\n" +
                    "                'name' : 'Claudia Sosa',\n" +
                    "                'twitter' : 'claudiagizela',\n" +
                    "                'workplace' : 'BBVA'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : '• Never stop running • Innovation, my love • Let’s talk #OpenInnovation, #APIs & #OpenBanking • @archivomodamex',\n" +
                    "                'category' : 14,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/845058986034397185/T6ixCftF_400x400.jpg',\n" +
                    "                'jobtitle' : 'Innovation Manager',\n" +
                    "                'name' : 'Elina Corona',\n" +
                    "                'twitter' : 'ninscorona',\n" +
                    "                'workplace' : 'Open Banking'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Co-fundador y CEO de Iconic, empresario y estratega en servicios tecnológicos. Reconocido en el MIT Technology Review Innovator under 35 Awards como innovador social por su proyecto Votosocial.org',\n" +
                    "                'category' : 8,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/1102611265720107009/rUulO29A_400x400.png',\n" +
                    "                'jobtitle' : 'CTO - Co-founder',\n" +
                    "                'name' : 'Jorge Garcia',\n" +
                    "                'twitter' : 'jagbolanos',\n" +
                    "                'workplace' : 'Iconic'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Fue de los primeros webmasters en Guatemala. Su carrera inició en julio de 1997 cuando fundó Maestros del Web, plataforma que contenía cursos, noticias, tips y una gran comunidad de desarrolladores web con una misión: difundir el uso del internet y sus tecnologías. Durante 15 años, esta plataforma se convirtió en un referente a nivel Latinoamericano. Años más tarde, en 2004, cofundó Guate360, un blog dedicado a la comunidad guatemalteca donde se promociona al país a través de fotos, recetas de comida, tours virtuales, directorio de hoteles, restaurantes y atractivos turísticos. En 2009 vendió sus acciones. Las iniciativas de Christian continuaron y su amplio conocimiento en el campo le abrió muchas oportunidades para continuar emprendiendo. Fue así como en marzo de 2012 cofunda IntegraTics, una plaza dedicada a la educación en línea. Desde sus inicios, la plataforma ha roto esquemas de la educación en la web y se dedica a enseñar cursos sobre diseño, marketing y programación, impartidos por líderes de la industria tecnológica que promueven el desarrollo de habilidades tecnológicas profesionales. Actualmente posee más de 600 mil estudiantes en todo el mundo y tiene una tasa de finalización del 70%. En IntegraTics, Christian se preocupa por hablar con los estudiantes, desarrollar la estrategia de contenido, gestionar la logística, los recursos financieros y los recursos humanos de la empresa.',\n" +
                    "                'category' : 2,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/703539825853464577/jppQNmXD_400x400.jpg',\n" +
                    "                'jobtitle' : 'Co-fundador',\n" +
                    "                'name' : 'Christian Van Der Henst',\n" +
                    "                'twitter' : 'cvander',\n" +
                    "                'workplace' : 'IntegraTics'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Periodista. De #Michoacán. Madrileña adoptiva. Siempre una escala en #GDL. No como pizza con piña. Le voy al @ClubAmerica. Defeña.',\n" +
                    "                'category' : 13,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/1231252218562646019/X_NpdqKK_400x400.jpg',\n" +
                    "                'jobtitle' : 'Periodista',\n" +
                    "                'name' : 'Veronica Calderon',\n" +
                    "                'twitter' : 'veronicalderon',\n" +
                    "                'workplace' : ''\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Colombiano, fue elegido uno de los 20 latinos más influyentes del año en la industria de la tecnología por CNET en Español, al lado de personalidades que trabajan en empresas como Tesla, Google, Apple, Microsoft, Samsung y GitHub. Cumplió 33 años hace poco, pero tenía solo 17 años cuando fundó Cristalab.com, cuya comunidad se convirtió en una referencia en diseño interactivo, desarrollo web y programación. Antes de ser el socio de Christian, era su competidor. Arrancaron esto con un streaming semanal, que hoy reconoces como IntegraTics Live cada semana. Todo cambió entre otras cosas con un viaje que hicieron juntos a Japón - la cultura japonesa es una pasión que comparten. Son parte de la red Endeavor y de los alumni de Y Combinator. Este importante programa de apoyo a emprendimientos los aceptó en su versión del 2015, donde fueron la primera empresa de la región cuya audiencia estaba en Latinoamérica. Freddy está a cargo de dirigir la empresa, de reclutamiento y también es de nuestro más reconocidos profesores. Además del curso de programación básica, también es uno de los instructores de nuestro taller de startups, exclusivo para los estudiantes con suscripción anual de IntegraTics. Su autor favorito es el escritor de ciencia ficción Robert A. Heinlein. Es aficionado al tiro deportivo, a la astronomía… y al lanzamiento de drones.',\n" +
                    "                'category' : 1,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/1062767896269590528/vOsDt9up_400x400.jpg',\n" +
                    "                'jobtitle' : 'CEO',\n" +
                    "                'name' : 'Freddy Vega',\n" +
                    "                'twitter' : 'freddier',\n" +
                    "                'workplace' : 'IntegraTics'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Cada cuadro tiene un proceso que debe hacerse antes de la acción de juego.',\n" +
                    "                'category' : 17,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/976117964591087617/61w43dr0_400x400.jpg',\n" +
                    "                'jobtitle' : 'Production Manager',\n" +
                    "                'name' : 'Erika Oregel',\n" +
                    "                'twitter' : 'oregeler',\n" +
                    "                'workplace' : 'IntegraTics'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Course Director del equipo de Education en IntegraTics. Blogguera y periodista del Universal en México, especialista en técnicas orales y escritas del periodismo con una amplia visión en el mundo digital.',\n" +
                    "                'category' : 7,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/674117824135081984/p5SJ33YJ_400x400.jpg',\n" +
                    "                'jobtitle' : 'Course Director',\n" +
                    "                'name' : 'Isis García',\n" +
                    "                'twitter' : 'IsisConVelo',\n" +
                    "                'workplace' : 'IntegraTics'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Director and cinematographer. Writer, Podcaster and teacher of audiovisual content.',\n" +
                    "                'category' : 16,\n" +
                    "                'image' : 'https://media-exp2.licdn.com/dms/image/C4E03AQF-6RBsJ6-iDA/profile-displayphoto-shrink_800_800/0?e=1585180800&v=beta&t=yLMYrEr0O19UdV30I2Ff2LgjMDDyoWH9qpDGSIXNgA8',\n" +
                    "                'jobtitle' : 'Writer',\n" +
                    "                'name' : 'Nicolay Coral',\n" +
                    "                'twitter' : 'nicolaycoral',\n" +
                    "                'workplace' : ''\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Mario Valle es uno de los mexicanos más prominentes de Silicon Valley. Fue pionero de la industria de videojuegos en América Latina y por 11 años fue ejecutivo de la gigante Electronic Arts.\u2028¿Por qué, entonces, dejarlo todo para lanzarse a ser inversionista?\u2028Mario (donante y fan #terco de la primera hora) nos cuenta que estaba cómodo y contento en EA. Pero la oportunidad que vio de invertir en videojuegos de creadores independientes en Asia, Europa, América Latina y hasta África le pareció demasiado grande para dejarla pasar.\u2028Lanzó Altered Ventures, un fondo que invierte como si fuera una productora de Hollywood: Le mete dinero a los proyectos, los videojuegos, y no a las empresas. Por lo tanto, no les pide a los desarrolladores que le cedan un porcentaje de propiedad de sus compañías, lo que –dice– en regiones como América Latina lleva a abusos de parte de los inversionistas. Mario tiene 36 millones de dólares para invertir en nuevos títulos y parte de su trabajo para lanzar el fondo fue viajar por el mundo jugando videojuegos para conocer qué es lo que viene. Ya invirtió en un juego innovador hecho en Noruega (que se lanza el 21 de junio en Nintendo Switch) y pronto vienen más.',\n" +
                    "                'category' : 3,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/1177427481831194625/MGmAHgel_400x400.jpg',\n" +
                    "                'jobtitle' : 'Angel Investor & Co-founder',\n" +
                    "                'name' : 'Mario Valle',\n" +
                    "                'twitter' : 'bilbeny',\n" +
                    "                'workplace' : 'Altered Ventures'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Tuerto en país de ciegos | Nerd empedernido | Constructor de marcas | Estratega digital',\n" +
                    "                'category' : 15,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/1125995646585065474/oJkHqDhY_400x400.png',\n" +
                    "                'jobtitle' : 'Director',\n" +
                    "                'name' : 'Ruben Gomez',\n" +
                    "                'twitter' : 'soyrubengomez',\n" +
                    "                'workplace' : 'gom360'\n" +
                    "            }\n" +
                    "        ]"
        )
        val firebaseFirestore = FirebaseFirestore.getInstance()

        for (i in 0 until jsonArr.length()) {
            val aux = jsonArr.getJSONObject(i)

            val ponente = Ponente()
                ponente.nombre = aux.optString("name"),
                ponente.profesion = aux.optString("jobtitle")
                ponente.trabajo = aux.optString("workplace")
                ponente.biografia = aux.optString("biography")
                ponente.twitter = aux.optString("twitter")
                ponente.imagen = aux.optString("image")
                ponente.categoria = aux.optInt("category")
                firebaseFirestore.collection("Ponentes").document().set(ponente)
        }

    }

}