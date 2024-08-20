package repositories

import data.Destination

object DestinationRepository {

     fun getBariloche(): Destination {
        return Destination(
            1L,
            "Bariloche",
            "San Carlos de Bariloche (comúnmente llamada Bariloche) es una ciudad en la región de la Patagonia argentina. Limita con Nahuel Huapi, un gran lago glacial rodeado de montañas de los Andes. Bariloche es conocida por su arquitectura al estilo alpino de Suiza y su chocolate, que se vende en tiendas de la calle Mitre, la avenida principal.",
            listOf("https://media.ambito.com/p/09dc04d56f9a00e9d087163f0cd76465/adjuntos/239/imagenes/040/404/0040404265/foto-bariloche-1-1png.png", "https://i0.wp.com/barilocheparabrasileiros.com.br/wp-content/uploads/2020/08/Guia-de-Inverno.jpeg", "https://media.istockphoto.com/id/820824654/es/foto/bariloche-lago-nahuel-huapi.jpg?s=612x612&w=0&k=20&c=UIe5LkCmk1zAZRFEFnVdAbEncUSPAtpPdRf0KtQHpjo=")
        )
    }

     fun getMendoza(): Destination {
        return Destination(
            2L,
            "Mendoza",
            "Mendoza es una ciudad de la región de Cuyo en Argentina y es el corazón de la zona vitivinícola argentina, famosa por sus Malbecs y otros vinos tintos. Sus distintas bodegas ofrecen degustaciones y visitas guiadas. La ciudad tiene calles amplias y frondosas rodeadas de edificios modernos y art déco, y con plazas más pequeñas que rodean la Plaza Independencia, sitio del Museo Municipal de Arte Moderno subterráneo, que exhibe arte moderno y contemporáneo.",
            listOf("https://media.tacdn.com/media/attractions-splice-spp-674x446/07/20/a5/f9.jpg", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/10/3c/2b/f1/p1090956-1-largejpg.jpg", "https://i0.wp.com/diariosanrafael.com.ar/wp-content/uploads/2022/07/turismo-mendoza.jpg")
        )
    }

     fun getMerlo(): Destination {
        return Destination(
            3L,
            "San Luis, Merlo",
            "Villa de Merlo es una ciudad de la provincia de San Luis, en la zona central de Argentina. Se ubica a los pies de las montañas Comechingones. En el centro de la ciudad se encuentra la Iglesia de Nuestra Señora del Rosario, construida en el siglo XVIII con adobe. El Museo del Poeta Antonio Esteban Agüero está ubicado en la antigua casa del poeta y documenta su vida y su obra. Un camino al este de la ciudad sube al Mirador del Sol, con vistas panorámicas de las montañas",
            listOf("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/16/15/a1/31/pasos-malos-circuito.jpg", "https://sanluis24.com.ar/wp-content/uploads/2023/01/marli.jpg", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/45/Ruta_en_Merlo.jpg/294px-Ruta_en_Merlo.jpg")
        )
    }

     fun getTermas(): Destination {
        return Destination(
            4L,
            "Termas de Colon",
            "Termas Colón, ofrece un entorno singular de riquezas naturales, donde agua, flora, fauna y paisaje se conjugan para formar un microclima especial que despierta en el visitante una sensación de bienestar y relax.",
            listOf("https://www.turismoentrerios.com/colon/img/termas-01.jpg", "https://images.squarespace-cdn.com/content/v1/53eab704e4b0dfc0547d4034/1633806050800-8IJ0VJN8Z6S5SGCI2N5P/Termas1.png", "https://media.lacapital.com.ar/p/ef0450cb5f0d625e6ff53cb69f491a3a/adjuntos/203/imagenes/100/113/0100113846/1200x675/smart/parque-destacadajpg.jpg")
        )
    }

     fun getCordoba(): Destination {
        return Destination(
            5L,
            "Cordoba",
            "Córdoba, la capital de la provincia argentina del mismo nombre, es conocida por su arquitectura colonial española. Alberga la Manzana Jesuítica, un complejo del siglo XVII con claustros activos, iglesias y el campus original de la Universidad Nacional de Córdoba, una de las universidades más antiguas de Sudamérica. El punto central de la ciudad es la Plaza San Martín y la Catedral de Córdoba de estilo neobarroco",
            listOf("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/12/6e/55/07/catedral-de-cordoba.jpg", "https://www.cordobaturismo.gov.ar/wp-content/uploads/2018/09/Villa-Carlos-Paz.jpg", "https://hotelvesubio.com/wp-content/uploads/2022/02/reloj-cucu.jpeg")
        )
    }

    fun getEsterosDelIbera(): Destination {
        return Destination(
            6L,
            "Esteros del Ibera, Corrientes",
            "La Reserva Provincial del Iberá es un área protegida dentro de los extensos Esteros del Iberá, en el noreste de Argentina. Abarca pantanos, ciénagas y lagunas que se extienden al suroeste desde la ciudad de Ituzaingó hasta Chavarría. Junto a la laguna Iberá está la villa Colonia Carlos Pellegrini, que sirve de base en el área. La reserva tiene una fauna abundante que incluye caimanes, ciervos de los pantanos y cientos de especies de aves.",
            listOf("https://www.boomerangviajes.tur.ar/wp-content/uploads/2022/01/Travesia-en-Kayak-por-Esteros-1067x800.jpg", "https://www.cambacuaibera.com.ar/images/home/Home2.jpg", "https://media-cdn.tripadvisor.com/media/photo-s/07/a9/7c/62/esteros-del-ibera.jpg")
        )
    }

    fun getUshuaia(): Destination {
        return Destination(
            7L,
            "Tierra del Fuego",
            "Ushuaia es una ciudad turística de Argentina. Se ubica en el archipiélago de Tierra del Fuego, el extremo austral de Sudamérica, apodado el Fin del Mundo. Esta ciudad con mucho viento, ubicada en una escarpada colina, está rodeada de los montes Martial y el canal Beagle. Es una vía de acceso a los cruceros hacia la Antártida y a los recorridos cerca de la Isla Yécapasela, conocida como la Isla Pingüino por sus colonias de esta especie",
            listOf("https://denomades.s3.us-west-2.amazonaws.com/blog/wp-content/uploads/2018/08/30192236/26824519578_6a65e00419_o.jpg", "https://assets.isu.pub/document-structure/230227205753-1d4950002a497fe2707e7f13d447b5cd/v1/5710027cd9b32bd9d95924309e92b887.jpeg", "https://i0.wp.com/elplanetaurbano.com/wp-content/uploads/2023/02/la_ciudad_fueguina_de_ushuaia.jpg")
        )
    }

    fun getSalta(): Destination {
        return Destination(
            8L,
            "Salta",
            "Salta es una capital provincial del noroeste montañoso de Argentina. Se fundó en 1582 y es conocida por su arquitectura colonial española y su herencia andina. La ciudad se centra en la Plaza 9 de Julio, elegante y rodeada de cafés, en torno a la cual se ubican la Catedral de Salta y El Cabildo, un ayuntamiento del siglo XVIII transformado en museo. En las cercanías, está el Museo de Arqueología de Alta Montaña (MAAM), que alberga artefactos incas y momias.",
            listOf("https://eqfsewpc7rt.exactdn.com/wp-content/uploads/2022/01/que-ahcer-en-salta-dia-por-dia.jpeg", "https://elacopleinformativo.com.ar/wp-content/uploads/2023/03/Salta.jpg")
        )
    }

    fun getColonia(): Destination {
        return Destination(
            9L,
            "Colonia",
            "Colonia es un departamento del suroeste de Uruguay, frente a Buenos Aires al otro lado del estuario del Río de la Plata. La capital departamental, Colonia del Sacramento, es conocida por su barrio histórico con adoquines y los edificios coloniales portugueses y españoles. Muchos albergan museos, incluido el Museo del Azulejo. El faro de Colonia del Sacramento está rodeado de las ruinas de un convento y tiene vista panorámica.",
            listOf("https://upload.wikimedia.org/wikipedia/commons/1/10/Calle_de_los_Suspiros%2C_Colonia_del_Sacramento%2C_Uruguay_-_panoramio.jpg", "https://imgar.zonapropcdn.com/avisos/1/00/51/01/85/96/720x532/1851485389.jpg")
        )
    }

    fun getCataratas(): Destination {
        return Destination(
            10L,
            "Iguazu",
            "Al norte de la provincia de Misiones, en el límite con Brasil, se encuentran las majestuosas Cataratas del Iguazú: una de las Siete Maravillas Naturales del Mundo y, sin dudas, uno de los lugares más espectaculares de Latinoamérica. Tanto su ubicación en medio de la selva como su descomunal volumen de agua y numerosos saltos las convierten en un sitio inolvidable y de obligada visita en todo viaje a Argentina. El Parque Nacional fue creado en 1934 y declarado Sitio de Patrimonio Mundial por la UNESCO en 1984. También recibió la mención de Área de Importancia para la Protección de las Aves (AICA).",
            listOf("https://www.fundacionaquae.org/wp-content/uploads/2016/01/800px_iguacu-002.jpg", "https://media-cdn.tripadvisor.com/media/photo-s/26/ce/02/d4/caption.jpg", "https://lavidasondosviajes.com/wp-content/uploads/2022/09/donde-alojarse-cataratas-del-iguazu.jpg")
        )
    }
}