package org.example.model;

public enum Language {
    RU_RU("ru-ru", "\uD83C\uDDF7\uD83C\uDDFARU-\uD83C\uDDF7\uD83C\uDDFARU"),
    RU_EN("ru-en", "\uD83C\uDDF7\uD83C\uDDFARU-\uD83C\uDDEC\uD83C\uDDE7EN"),
    RU_TR("ru-tr", "\uD83C\uDDF7\uD83C\uDDFARU-\uD83C\uDDF9\uD83C\uDDF7TR"),
    EN_RU("en-ru", "\uD83C\uDDEC\uD83C\uDDE7EN-\uD83C\uDDF7\uD83C\uDDFARU"),
    EN_EN("en-en", "\uD83C\uDDEC\uD83C\uDDE7EN-\uD83C\uDDEC\uD83C\uDDE7EN"),
    EN_TR("en-tr", "\uD83C\uDDEC\uD83C\uDDE7EN-\uD83C\uDDF9\uD83C\uDDF7TR"),
    TR_RU("tr-ru", "\uD83C\uDDF9\uD83C\uDDF7TR-\uD83C\uDDF7\uD83C\uDDFARU"),
    TR_EN("tr-en", "\uD83C\uDDF9\uD83C\uDDF7TR-\uD83C\uDDEC\uD83C\uDDE7EN"),
    TR_TR("tr-tr", "\uD83C\uDDF9\uD83C\uDDF7TR-\uD83C\uDDF9\uD83C\uDDF7TR");

    private final String code;
    private final String nameWithEmoji;

    Language(String code, String nameWithEmoji) {
        this.code = code;
        this.nameWithEmoji = nameWithEmoji;
    }

    public String getCode() {
        return code;
    }

    public String getNameWithEmoji() {
        return nameWithEmoji;
    }
}
