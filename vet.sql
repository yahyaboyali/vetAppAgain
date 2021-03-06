PGDMP     	                    z            vetApplication    13.3    13.3     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    57547    vetApplication    DATABASE     m   CREATE DATABASE "vetApplication" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1254';
     DROP DATABASE "vetApplication";
                postgres    false            ?            1259    57553    animal    TABLE       CREATE TABLE public.animal (
    animal_id integer NOT NULL,
    species character varying(20) NOT NULL,
    genus character varying(20) NOT NULL,
    animal_age integer NOT NULL,
    explanation text NOT NULL,
    person_id integer NOT NULL,
    animal_name character varying(20)
);
    DROP TABLE public.animal;
       public         heap    postgres    false            ?            1259    57563    animal_animal_id_seq    SEQUENCE     ?   ALTER TABLE public.animal ALTER COLUMN animal_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.animal_animal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    201            ?            1259    57548    person    TABLE     _  CREATE TABLE public.person (
    person_id integer NOT NULL,
    person_name character varying(20) NOT NULL,
    person_lastname character varying(20) NOT NULL,
    phone_number character varying(11) NOT NULL,
    email character varying(50) NOT NULL,
    authority character varying(5) NOT NULL,
    person_password character varying(20) NOT NULL
);
    DROP TABLE public.person;
       public         heap    postgres    false            ?            1259    57561    user_user_id_seq    SEQUENCE     ?   ALTER TABLE public.person ALTER COLUMN person_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.user_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    200            ?          0    57553    animal 
   TABLE DATA           l   COPY public.animal (animal_id, species, genus, animal_age, explanation, person_id, animal_name) FROM stdin;
    public          postgres    false    201   4       ?          0    57548    person 
   TABLE DATA           z   COPY public.person (person_id, person_name, person_lastname, phone_number, email, authority, person_password) FROM stdin;
    public          postgres    false    200   ?       ?           0    0    animal_animal_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.animal_animal_id_seq', 42, true);
          public          postgres    false    203            ?           0    0    user_user_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.user_user_id_seq', 8, true);
          public          postgres    false    202            ,           2606    57560    animal animal_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.animal
    ADD CONSTRAINT animal_pkey PRIMARY KEY (animal_id);
 <   ALTER TABLE ONLY public.animal DROP CONSTRAINT animal_pkey;
       public            postgres    false    201            *           2606    57552    person user_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.person
    ADD CONSTRAINT user_pkey PRIMARY KEY (person_id);
 :   ALTER TABLE ONLY public.person DROP CONSTRAINT user_pkey;
       public            postgres    false    200            -           1259    57570    fki_animal_user    INDEX     G   CREATE INDEX fki_animal_user ON public.animal USING btree (person_id);
 #   DROP INDEX public.fki_animal_user;
       public            postgres    false    201            .           2606    57571    animal person_animal    FK CONSTRAINT     ?   ALTER TABLE ONLY public.animal
    ADD CONSTRAINT person_animal FOREIGN KEY (person_id) REFERENCES public.person(person_id) NOT VALID;
 >   ALTER TABLE ONLY public.animal DROP CONSTRAINT person_animal;
       public          postgres    false    200    201    2858            ?   ?   x?]?Q?0???Sp#cD??/?5K??1??[x?^?0????O??m?3h??R)*0???]C}?????j???&?q`'??,v~5(ҁ`?*o?)!vtcZ?XիFE,/???抯X????ԩ???=?ul???<?>?f8?u?CGN??UR|???аk???????ާ??)-?1???cH      ?   ?   x?m?A?0E???:??;???DJIPLz,6^@f?0tv3o^~>?Sw????2?RJ!"?8?Z?MRw-8z ?LH???,??`???ֳ&??H/zS?7?t?i?
?b?????t?^??9|޽?&?Mc??ξ?9?_?????ٿ???h/?????????1????j     