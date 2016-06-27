package com.rflpazini.treinofitness.db;


import android.provider.BaseColumns;

public class DbInfo {
    public static final String DB_NAME = "com.treinofitness.db";
    public static final int DB_VERSION = 2;

    public class DbEntry implements BaseColumns {

        /**
         * Table for avaliações físicas
         */
        public static final String AVALIACOES_TABLE = "avals";
        public static final String AVAL_PEITO = "peito";
        public static final String AVAL_ALTURA = "altura";
        public static final String AVAL_PESO = "peso";
        public static final String AVAL_OMBRO = "ombro";
        public static final String AVAL_CINTURA = "cintura";
        public static final String AVAL_BRA_ESQ = "braco_esquerdo";
        public static final String AVAL_BRA_DIR = "braco_direito";
        public static final String AVAL_ANT_BRA_ESQ = "ante_braco_esquerdo";
        public static final String AVAL_ANT_BRA_DIR = "ante_braco_direito";
        public static final String AVAL_COXA_ESQ = "coxa_esquerda";
        public static final String AVAL_COXA_DIR = "coxa_direita";

        /**
         * Table for anamnese
         */
        public static final String ANAMNESE_TABLE = "anamnese";
        public static final String ANAM_HIPERT = "hipertensao";
        public static final String ANAM_DIABETE = "diabete";
        public static final String ANAM_ARTICU = "articulacao";
        public static final String ANAM_FUMA = "fumante";
        public static final String ANAM_ESTRES = "estresse";
        public static final String ANAM_CARDIACO = "cardiaco";
        public static final String ANAM_MUSCULAR = "muscular";
    }
}
