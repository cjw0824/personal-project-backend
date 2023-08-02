package com.example.demo.boardMockingTest;

import com.example.demo.board.controller.form.BoardRequestForm;
import com.example.demo.board.entity.Board;
import com.example.demo.board.service.BoardServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.repository.BoardRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class boardTest {

//  @Mock : 가짜 객체를 만들어 반환해주는 어노테이션
    @Mock
    private BoardRepository mockBoardRepository;


//  @InjectMocks : 생성된 가짜 객체를 자동으로 주입시켜주는 어노테이션
    @InjectMocks
    private BoardServiceImpl mockBoardServiceImpl;

// 각 테스트 메서드 실행 전에
// MockitoAnnotations.initMocks(this)를 호출하여 Mock 객체를 초기화한다.
    @BeforeEach
    public void setup () throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    @DisplayName("Mocking: 게시물 작성 테스트")
    public void 게시물_작성() {
        String title = "제목";
        String content = "내용";
        String userEmail = "작성자";
        BoardRequestForm boardRequestForm = new BoardRequestForm(title, content, userEmail);
        Board board = boardRequestForm.toBoard();

        // 가상의 예측 결과
        when(mockBoardRepository.save(board)).thenReturn(new Board("제목", "작성자", "내용"));

        // 실제 구동 테스트
        final BoardServiceImpl sut = new BoardServiceImpl(mockBoardRepository); //임의의 가짜 객체를 생성해줌
        sut.register(boardRequestForm);
        final Board actual = boardRequestForm.toBoard();

        // 예측결과와 일치하는지 확인
        assertEquals(actual.getTitle(), board.getTitle());

        // 메소드 검증 방법
        // verify(T mock, VerificationMode mode)
        // 예시 >> verify(mockBoardRepository, times(1)).deleteById(0L);
        // VerificationMode 로는 times(n), never, description 등등... 이 있다.
        //( times() : 몇 번이 호출됐는지 검증, never : 한 번도 호출되지 않았는지 검증,  description : 실패한 경우 나올 문구 )
    }
}
