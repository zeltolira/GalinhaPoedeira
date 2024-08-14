package com.lira.GalinhaPoedeira.Galinha.domain;

public enum StatusGalinha {
    ATIVA
            {
        @Override
        public boolean podeProduzirOvos() {
            return true;
        }

        @Override
        public String getStatus() {
            return "Galinha ativa, pronta para produzir ovos.";
        }
    },
    INATIVA {
        @Override
        public boolean podeProduzirOvos() {
            return false;
        }

        @Override
        public String getStatus() {
            return "Galinha inativa, não pode produzir ovos.";
        }
    };

    public abstract boolean podeProduzirOvos();
    public abstract String getStatus();
}
