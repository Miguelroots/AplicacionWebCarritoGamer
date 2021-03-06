PGDMP     +                    z            PIS_GB    14.1    14.1 E    =           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            >           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            @           1262    33655    PIS_GB    DATABASE     f   CREATE DATABASE "PIS_GB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Ecuador.1252';
    DROP DATABASE "PIS_GB";
                postgres    false            ?            1259    33926    carrito    TABLE     ?   CREATE TABLE public.carrito (
    id_carrito integer NOT NULL,
    cantidad integer NOT NULL,
    id_usuario integer NOT NULL,
    id_producto integer NOT NULL
);
    DROP TABLE public.carrito;
       public         heap    postgres    false            ?            1259    33925    carrito_id_carrito_seq    SEQUENCE     ?   CREATE SEQUENCE public.carrito_id_carrito_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.carrito_id_carrito_seq;
       public          postgres    false    218            A           0    0    carrito_id_carrito_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.carrito_id_carrito_seq OWNED BY public.carrito.id_carrito;
          public          postgres    false    217            ?            1259    33903    categoria_producto    TABLE     ?   CREATE TABLE public.categoria_producto (
    id_categoria_producto integer NOT NULL,
    descripcion character varying NOT NULL
);
 &   DROP TABLE public.categoria_producto;
       public         heap    postgres    false            ?            1259    33902 ,   categoria_producto_id_categoria_producto_seq    SEQUENCE     ?   CREATE SEQUENCE public.categoria_producto_id_categoria_producto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 C   DROP SEQUENCE public.categoria_producto_id_categoria_producto_seq;
       public          postgres    false    214            B           0    0 ,   categoria_producto_id_categoria_producto_seq    SEQUENCE OWNED BY     }   ALTER SEQUENCE public.categoria_producto_id_categoria_producto_seq OWNED BY public.categoria_producto.id_categoria_producto;
          public          postgres    false    213            ?            1259    33974    detalle_orden    TABLE     ?   CREATE TABLE public.detalle_orden (
    id_detalle_orden integer NOT NULL,
    id_orden integer NOT NULL,
    id_producto integer NOT NULL,
    cantidad integer NOT NULL,
    precio numeric NOT NULL
);
 !   DROP TABLE public.detalle_orden;
       public         heap    postgres    false            ?            1259    33973 "   detalle_orden_id_detalle_orden_seq    SEQUENCE     ?   CREATE SEQUENCE public.detalle_orden_id_detalle_orden_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public.detalle_orden_id_detalle_orden_seq;
       public          postgres    false    224            C           0    0 "   detalle_orden_id_detalle_orden_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE public.detalle_orden_id_detalle_orden_seq OWNED BY public.detalle_orden.id_detalle_orden;
          public          postgres    false    223            ?            1259    33889    envio    TABLE     r  CREATE TABLE public.envio (
    id_envio integer NOT NULL,
    pais character varying NOT NULL,
    nombre character varying NOT NULL,
    direccion character varying NOT NULL,
    ciudad character varying NOT NULL,
    provincia character varying NOT NULL,
    codigo_postal character varying NOT NULL,
    telefono integer NOT NULL,
    id_usuario integer NOT NULL
);
    DROP TABLE public.envio;
       public         heap    postgres    false            ?            1259    33888    envio_id_envio_seq    SEQUENCE     ?   CREATE SEQUENCE public.envio_id_envio_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.envio_id_envio_seq;
       public          postgres    false    212            D           0    0    envio_id_envio_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.envio_id_envio_seq OWNED BY public.envio.id_envio;
          public          postgres    false    211            ?            1259    33943    metodo_pago    TABLE     u   CREATE TABLE public.metodo_pago (
    id_metodo_pago integer NOT NULL,
    descripcion character varying NOT NULL
);
    DROP TABLE public.metodo_pago;
       public         heap    postgres    false            ?            1259    33942    metodo_pago_id_metodo_pago_seq    SEQUENCE     ?   CREATE SEQUENCE public.metodo_pago_id_metodo_pago_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.metodo_pago_id_metodo_pago_seq;
       public          postgres    false    220            E           0    0    metodo_pago_id_metodo_pago_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.metodo_pago_id_metodo_pago_seq OWNED BY public.metodo_pago.id_metodo_pago;
          public          postgres    false    219            ?            1259    33952    orden    TABLE     ?   CREATE TABLE public.orden (
    id_orden integer NOT NULL,
    id_usuario integer NOT NULL,
    id_metodo_pago integer NOT NULL,
    id_envio integer NOT NULL,
    total numeric NOT NULL
);
    DROP TABLE public.orden;
       public         heap    postgres    false            ?            1259    33951    orden_id_orden_seq    SEQUENCE     ?   CREATE SEQUENCE public.orden_id_orden_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.orden_id_orden_seq;
       public          postgres    false    222            F           0    0    orden_id_orden_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.orden_id_orden_seq OWNED BY public.orden.id_orden;
          public          postgres    false    221            ?            1259    33912    producto    TABLE       CREATE TABLE public.producto (
    id_producto integer NOT NULL,
    nombre character varying NOT NULL,
    precio numeric NOT NULL,
    descripcion character varying NOT NULL,
    id_categoria_producto integer NOT NULL,
    imagen character varying NOT NULL
);
    DROP TABLE public.producto;
       public         heap    postgres    false            ?            1259    33911    producto_id_producto_seq    SEQUENCE     ?   CREATE SEQUENCE public.producto_id_producto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.producto_id_producto_seq;
       public          postgres    false    216            G           0    0    producto_id_producto_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.producto_id_producto_seq OWNED BY public.producto.id_producto;
          public          postgres    false    215            ?            1259    33879    usuario    TABLE     S  CREATE TABLE public.usuario (
    id_usuario integer NOT NULL,
    nombre character varying NOT NULL,
    apellido character varying NOT NULL,
    pais character varying NOT NULL,
    sexo character varying NOT NULL,
    fecha_nacimiento date NOT NULL,
    contrasena character varying NOT NULL,
    nickname character varying NOT NULL
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            ?            1259    33878    usuario_id_usuario_seq    SEQUENCE     ?   CREATE SEQUENCE public.usuario_id_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.usuario_id_usuario_seq;
       public          postgres    false    210            H           0    0    usuario_id_usuario_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.usuario_id_usuario_seq OWNED BY public.usuario.id_usuario;
          public          postgres    false    209            ?           2604    33929    carrito id_carrito    DEFAULT     x   ALTER TABLE ONLY public.carrito ALTER COLUMN id_carrito SET DEFAULT nextval('public.carrito_id_carrito_seq'::regclass);
 A   ALTER TABLE public.carrito ALTER COLUMN id_carrito DROP DEFAULT;
       public          postgres    false    217    218    218            ?           2604    33906 (   categoria_producto id_categoria_producto    DEFAULT     ?   ALTER TABLE ONLY public.categoria_producto ALTER COLUMN id_categoria_producto SET DEFAULT nextval('public.categoria_producto_id_categoria_producto_seq'::regclass);
 W   ALTER TABLE public.categoria_producto ALTER COLUMN id_categoria_producto DROP DEFAULT;
       public          postgres    false    213    214    214            ?           2604    33977    detalle_orden id_detalle_orden    DEFAULT     ?   ALTER TABLE ONLY public.detalle_orden ALTER COLUMN id_detalle_orden SET DEFAULT nextval('public.detalle_orden_id_detalle_orden_seq'::regclass);
 M   ALTER TABLE public.detalle_orden ALTER COLUMN id_detalle_orden DROP DEFAULT;
       public          postgres    false    223    224    224            ?           2604    33892    envio id_envio    DEFAULT     p   ALTER TABLE ONLY public.envio ALTER COLUMN id_envio SET DEFAULT nextval('public.envio_id_envio_seq'::regclass);
 =   ALTER TABLE public.envio ALTER COLUMN id_envio DROP DEFAULT;
       public          postgres    false    211    212    212            ?           2604    33946    metodo_pago id_metodo_pago    DEFAULT     ?   ALTER TABLE ONLY public.metodo_pago ALTER COLUMN id_metodo_pago SET DEFAULT nextval('public.metodo_pago_id_metodo_pago_seq'::regclass);
 I   ALTER TABLE public.metodo_pago ALTER COLUMN id_metodo_pago DROP DEFAULT;
       public          postgres    false    220    219    220            ?           2604    33955    orden id_orden    DEFAULT     p   ALTER TABLE ONLY public.orden ALTER COLUMN id_orden SET DEFAULT nextval('public.orden_id_orden_seq'::regclass);
 =   ALTER TABLE public.orden ALTER COLUMN id_orden DROP DEFAULT;
       public          postgres    false    221    222    222            ?           2604    33915    producto id_producto    DEFAULT     |   ALTER TABLE ONLY public.producto ALTER COLUMN id_producto SET DEFAULT nextval('public.producto_id_producto_seq'::regclass);
 C   ALTER TABLE public.producto ALTER COLUMN id_producto DROP DEFAULT;
       public          postgres    false    216    215    216                       2604    33882    usuario id_usuario    DEFAULT     x   ALTER TABLE ONLY public.usuario ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuario_id_usuario_seq'::regclass);
 A   ALTER TABLE public.usuario ALTER COLUMN id_usuario DROP DEFAULT;
       public          postgres    false    210    209    210            4          0    33926    carrito 
   TABLE DATA           P   COPY public.carrito (id_carrito, cantidad, id_usuario, id_producto) FROM stdin;
    public          postgres    false    218   ?S       0          0    33903    categoria_producto 
   TABLE DATA           P   COPY public.categoria_producto (id_categoria_producto, descripcion) FROM stdin;
    public          postgres    false    214   T       :          0    33974    detalle_orden 
   TABLE DATA           b   COPY public.detalle_orden (id_detalle_orden, id_orden, id_producto, cantidad, precio) FROM stdin;
    public          postgres    false    224   ?T       .          0    33889    envio 
   TABLE DATA           z   COPY public.envio (id_envio, pais, nombre, direccion, ciudad, provincia, codigo_postal, telefono, id_usuario) FROM stdin;
    public          postgres    false    212   ?T       6          0    33943    metodo_pago 
   TABLE DATA           B   COPY public.metodo_pago (id_metodo_pago, descripcion) FROM stdin;
    public          postgres    false    220   ?U       8          0    33952    orden 
   TABLE DATA           V   COPY public.orden (id_orden, id_usuario, id_metodo_pago, id_envio, total) FROM stdin;
    public          postgres    false    222   ?U       2          0    33912    producto 
   TABLE DATA           k   COPY public.producto (id_producto, nombre, precio, descripcion, id_categoria_producto, imagen) FROM stdin;
    public          postgres    false    216   &V       ,          0    33879    usuario 
   TABLE DATA           s   COPY public.usuario (id_usuario, nombre, apellido, pais, sexo, fecha_nacimiento, contrasena, nickname) FROM stdin;
    public          postgres    false    210   OZ       I           0    0    carrito_id_carrito_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.carrito_id_carrito_seq', 17, true);
          public          postgres    false    217            J           0    0 ,   categoria_producto_id_categoria_producto_seq    SEQUENCE SET     Z   SELECT pg_catalog.setval('public.categoria_producto_id_categoria_producto_seq', 8, true);
          public          postgres    false    213            K           0    0 "   detalle_orden_id_detalle_orden_seq    SEQUENCE SET     Q   SELECT pg_catalog.setval('public.detalle_orden_id_detalle_orden_seq', 12, true);
          public          postgres    false    223            L           0    0    envio_id_envio_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.envio_id_envio_seq', 18, true);
          public          postgres    false    211            M           0    0    metodo_pago_id_metodo_pago_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.metodo_pago_id_metodo_pago_seq', 2, true);
          public          postgres    false    219            N           0    0    orden_id_orden_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.orden_id_orden_seq', 6, true);
          public          postgres    false    221            O           0    0    producto_id_producto_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.producto_id_producto_seq', 26, true);
          public          postgres    false    215            P           0    0    usuario_id_usuario_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.usuario_id_usuario_seq', 5, true);
          public          postgres    false    209            ?           2606    33931    carrito carrito_pk 
   CONSTRAINT     X   ALTER TABLE ONLY public.carrito
    ADD CONSTRAINT carrito_pk PRIMARY KEY (id_carrito);
 <   ALTER TABLE ONLY public.carrito DROP CONSTRAINT carrito_pk;
       public            postgres    false    218            ?           2606    33910 (   categoria_producto categoria_producto_pk 
   CONSTRAINT     y   ALTER TABLE ONLY public.categoria_producto
    ADD CONSTRAINT categoria_producto_pk PRIMARY KEY (id_categoria_producto);
 R   ALTER TABLE ONLY public.categoria_producto DROP CONSTRAINT categoria_producto_pk;
       public            postgres    false    214            ?           2606    33979    detalle_orden detalle_orden_pk 
   CONSTRAINT     j   ALTER TABLE ONLY public.detalle_orden
    ADD CONSTRAINT detalle_orden_pk PRIMARY KEY (id_detalle_orden);
 H   ALTER TABLE ONLY public.detalle_orden DROP CONSTRAINT detalle_orden_pk;
       public            postgres    false    224            ?           2606    33896    envio envio_pk 
   CONSTRAINT     R   ALTER TABLE ONLY public.envio
    ADD CONSTRAINT envio_pk PRIMARY KEY (id_envio);
 8   ALTER TABLE ONLY public.envio DROP CONSTRAINT envio_pk;
       public            postgres    false    212            ?           2606    33950    metodo_pago metodo_pago_pk 
   CONSTRAINT     d   ALTER TABLE ONLY public.metodo_pago
    ADD CONSTRAINT metodo_pago_pk PRIMARY KEY (id_metodo_pago);
 D   ALTER TABLE ONLY public.metodo_pago DROP CONSTRAINT metodo_pago_pk;
       public            postgres    false    220            ?           2606    33957    orden orden_pk 
   CONSTRAINT     R   ALTER TABLE ONLY public.orden
    ADD CONSTRAINT orden_pk PRIMARY KEY (id_orden);
 8   ALTER TABLE ONLY public.orden DROP CONSTRAINT orden_pk;
       public            postgres    false    222            ?           2606    33919    producto producto_pk 
   CONSTRAINT     [   ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_pk PRIMARY KEY (id_producto);
 >   ALTER TABLE ONLY public.producto DROP CONSTRAINT producto_pk;
       public            postgres    false    216            ?           2606    33886    usuario usuario_pk 
   CONSTRAINT     X   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pk PRIMARY KEY (id_usuario);
 <   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pk;
       public            postgres    false    210            ?           2606    33920    producto cat_producto_fk    FK CONSTRAINT     ?   ALTER TABLE ONLY public.producto
    ADD CONSTRAINT cat_producto_fk FOREIGN KEY (id_categoria_producto) REFERENCES public.categoria_producto(id_categoria_producto);
 B   ALTER TABLE ONLY public.producto DROP CONSTRAINT cat_producto_fk;
       public          postgres    false    216    214    3212            ?           2606    33968    orden envio_orden_fk    FK CONSTRAINT     z   ALTER TABLE ONLY public.orden
    ADD CONSTRAINT envio_orden_fk FOREIGN KEY (id_envio) REFERENCES public.envio(id_envio);
 >   ALTER TABLE ONLY public.orden DROP CONSTRAINT envio_orden_fk;
       public          postgres    false    3210    212    222            ?           2606    33963    orden metodo_pago_orden_fk    FK CONSTRAINT     ?   ALTER TABLE ONLY public.orden
    ADD CONSTRAINT metodo_pago_orden_fk FOREIGN KEY (id_metodo_pago) REFERENCES public.metodo_pago(id_metodo_pago);
 D   ALTER TABLE ONLY public.orden DROP CONSTRAINT metodo_pago_orden_fk;
       public          postgres    false    220    3218    222            ?           2606    33980    detalle_orden orden_detallle_fk    FK CONSTRAINT     ?   ALTER TABLE ONLY public.detalle_orden
    ADD CONSTRAINT orden_detallle_fk FOREIGN KEY (id_orden) REFERENCES public.orden(id_orden);
 I   ALTER TABLE ONLY public.detalle_orden DROP CONSTRAINT orden_detallle_fk;
       public          postgres    false    3220    224    222            ?           2606    33937    carrito producto_carrito_fk    FK CONSTRAINT     ?   ALTER TABLE ONLY public.carrito
    ADD CONSTRAINT producto_carrito_fk FOREIGN KEY (id_producto) REFERENCES public.producto(id_producto);
 E   ALTER TABLE ONLY public.carrito DROP CONSTRAINT producto_carrito_fk;
       public          postgres    false    216    218    3214            ?           2606    33985 "   detalle_orden producto_detallle_fk    FK CONSTRAINT     ?   ALTER TABLE ONLY public.detalle_orden
    ADD CONSTRAINT producto_detallle_fk FOREIGN KEY (id_producto) REFERENCES public.producto(id_producto);
 L   ALTER TABLE ONLY public.detalle_orden DROP CONSTRAINT producto_detallle_fk;
       public          postgres    false    224    216    3214            ?           2606    33932    carrito usuario_carrito_fk    FK CONSTRAINT     ?   ALTER TABLE ONLY public.carrito
    ADD CONSTRAINT usuario_carrito_fk FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario);
 D   ALTER TABLE ONLY public.carrito DROP CONSTRAINT usuario_carrito_fk;
       public          postgres    false    210    218    3208            ?           2606    33897    envio usuario_envio_fk    FK CONSTRAINT     ?   ALTER TABLE ONLY public.envio
    ADD CONSTRAINT usuario_envio_fk FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario);
 @   ALTER TABLE ONLY public.envio DROP CONSTRAINT usuario_envio_fk;
       public          postgres    false    210    212    3208            ?           2606    33958    orden usuario_orden_fk    FK CONSTRAINT     ?   ALTER TABLE ONLY public.orden
    ADD CONSTRAINT usuario_orden_fk FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario);
 @   ALTER TABLE ONLY public.orden DROP CONSTRAINT usuario_orden_fk;
       public          postgres    false    3208    222    210            4   J   x?5???0?0Lq?4?t?9j?"?@B?1#9вeqVL8?h?\U;?Hն?,5G???lN????*?      0   a   x?3????ITpO?M-?2??LI??*MM??2?t??+??I?2?J,???2?IM?IL??2?t,M?L???/?2???L.?q?,8}?R??1z\\\ M?<      :   7   x?%??  ??Q????????k?????m!?gB?UA?Y?!?T??? ?/      .   ?   x?m?=j1?zt?=A?F?+?)?@H*???dW$??EF?@no-?u?N?|????0U?3?'q??<?B?V??~kZ?28k4???5??]?nS*S??\????q???~t?2?-??#?sC?]???T?b??㨭+??%=?e????FoZմ??;#????X?Vo?9#??Nt???C??|e???g?I@?????^^?w6?m	      6      x?3?t.JM?,??2?tIM1b???? ViS      8   ?   x?-???@??]LDp???:??ɉ??L???š CH?嫗W??F????}???}      2     x???]n?8ǟ?S? ? ?J?}k??L?Sĝ??c+?:?Hvg??Z??bKIN?$N1/AR??I?T???D?Rڠ???3??h6?f?C΁>+?Y??%d?T?zS#?f????Y??o??????ZIe ???l8????틷?v??OSv??]?+?0d'?$r??^(??j??*??A?!sX7?Rd???$?/F,?R3fWX??V?GSo~?'?E??jx~,??FMqa?\?K?P?)/?S?aN,?X??;???j?9%?W5\4??'?ǲ? I?Z?'h?Z??[Z??j?D'59?r?r?%<?^??,??J	??V8????(??!|?+!%?l?;?z_?4e???.?3$l:f??????\g?(4???(@E?>??wC???T?????{N???a????A?_?]?Q-oL?7VuO???؂??5\???l??┨V??.??u?*?5?u???}???q????V±ֺ?WJWh??? ???iLO?????,?N??y??A4??????ю(?Լ?$?+?*??MT??\K??QȊ#Y)??ׄMb?z? ???Z?Q~?9]&???cۖi?+?F2??)ŕ	??????S??m{i?????>G??zZ?=m???t?x?7??????ĝq2.N??''l???nC???CS~#?tO??7??q?H????????'??^?%??n?q??x?Ӎ?X????[j??fk?j%????Zc?}??C??G????0???zc_!??? tӴ???p?~MG,??????<??*???hl??4N??9??????#?;???z??hr?rO???K?cxX|aAY??c?A?ť%He:
|?<\Q?????|???{?L???G?差???Xҫ???k??)?W?"kw?<??k?U?L}??m:t?sÞ??,?v?3?4?????wփ#6G????N??7vPg??Ock???H?:b?'=3n-?%ʬ5%,	??I]:ߎ?w?c???n"?ǒ? ??!??????ɱ?Y2;~?L߮??Gggg????      ,   ?   x?u?A
?0????]"ij?T?p?&?(SkB??Vo???)??????L????4P7j4?U?G?Q?Pņ??"???b?????޹.0??Kr?k?zN?Lr)0???ݘZ?r???ࠪ8)E??RB??	*?	Ρ.?5?9???7?j???帘\??I~ZV`k?	??TS=?s.?ޏ?n?1;?co??^|     