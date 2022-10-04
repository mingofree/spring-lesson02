package com.example.todoapp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.example.todoapp.entity.Task;

@SpringJUnitConfig // Junit5 上で Spring TestContext Framework を利用することを示す
@SpringBootTest // 毎回サーバ起動(DBとの連動のために必要)
@ActiveProfiles("unit") // application-unit.yml の unit を対応（DBの設定を読み込む）
@DisplayName("TaskServiceImplの結合テスト")
class TaskServiceImplTest {

  @Autowired
  private TaskService taskService;

  @Test
  @DisplayName("タスクが取得できない場合のテスト")
  void testGetTaskFormReturnNull() {

    try {
      taskService.getTask(0);
    } catch (TaskNotFoundException e) {
      assertEquals(e.getMessage(), "指定されたタスクが存在しません");
    }
  }

  @Test // order byがある場合は順序の確認をすることがある
  @DisplayName("全件検索のテスト")
  void testFindAllCheckCount() {
    // 全件取得
    List<Task> list = taskService.findAll();

    // Taskテーブルに入っている2件が取得できているか確認
    assertEquals(2, list.size());
  }

  @Test
  @DisplayName("1件のタスクが取得できた場合のテスト")
  void testGetTaskFormReturnOne() {
    // idが1のTaskを取得
    Optional<Task> taskOpt = taskService.getTask(1);

    // 取得できたことを確認(Win では、なぜか UTF-8 のファイルでないと文字化けでえらーとなる)
    assertEquals("JUnitを学習", taskOpt.get().getTitle());
  }
}
