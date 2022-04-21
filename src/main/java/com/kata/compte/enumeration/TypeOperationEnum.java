package com.kata.compte.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum TypeOperationEnum {

    /**
     * "depotCpt", "depotCpt"
     */
    DEPOT("depotCpt", "depotCpt"),
    /**
     * "retraitCpt", "retraitCpt"
     */
    RETRAIT("retraitCpt", "retraitCpt");
    protected static final Map<String, TypeOperationEnum> TABLE_MAPPING;
    private String code;
    private String libelle;
    static {
        TABLE_MAPPING = new HashMap<String, TypeOperationEnum>();
        TypeOperationEnum.TABLE_MAPPING.put(DEPOT.getCode(), DEPOT);
        TypeOperationEnum.TABLE_MAPPING.put(RETRAIT.getCode(), RETRAIT);
    }

    TypeOperationEnum(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
