## DB연동과 MVC패턴을 이용한 Memo

1. [Memo](https://github.com/dmsals216/MyStudy/blob/master/Java/MemoToMVCAndDB/src/model/Memo.java)

Memo의 index, name, content, datetime을 가진 객체

2. [Controller](https://github.com/dmsals216/MyStudy/blob/master/Java/MemoToMVCAndDB/src/controller/Memo_Controller.java)

각 처리를 비교하고 Model과 View 가운데에서 흐름을 관리한다.

3. [Dao](https://github.com/dmsals216/MyStudy/blob/master/Java/MemoToMVCAndDB/src/dao/Memo_Dao.java)

Database를 유일하게 다룬다.

4. [View](https://github.com/dmsals216/MyStudy/blob/master/Java/MemoToMVCAndDB/src/view/Memo_View.java)

사용자의 화면을 보여주는 역할을 한다.
