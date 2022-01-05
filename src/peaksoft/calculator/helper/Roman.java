package peaksoft.calculator.helper;

import lombok.Getter;

/**
 * created by Beksultan Mamatkadyr uulu
 * project : Calculator
 * 25/12/21
 * Saturday 16:42
 */
@Getter
public enum Roman {
    I("1"), F("4"), V("5"), N("9"),
    X("10"), L("50"), C("100"),T("400"),
    D("500"), P("900"), M("1000");

    private String value;

    Roman(String value) {
        this.value = value;
    }
}
