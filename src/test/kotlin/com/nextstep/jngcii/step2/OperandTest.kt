package com.nextstep.jngcii.step2

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class OperandTest {
    @ParameterizedTest
    @ValueSource(strings = ["1", "123", "4591283", "-523"])
    fun `operand 생성 성공 테스트`(input: String) {
        assertDoesNotThrow { Operand(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "a", "+"])
    fun `operand 생성 실패 테스트`(input: String) {
        assertThrows<IllegalArgumentException>("숫자형만 계산 가능합니다.") { Operand(input) }
    }
}