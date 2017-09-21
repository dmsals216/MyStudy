## LifeCycle

1. 생성과 관련된 생명주기

onCreate() -> onStart() -> onResume() -> Running

2. 소멸관련된 생명주기

onPause() -> onStop()

## List View

#### 리스트 사용하기

1. 데이터를 정의

2. 데이터와 리스트뷰를 연결하는 아답터를 생성

3. 아답터와 리스트뷰를 연결

## File

#### 내용을 파일에 작성

1. 내부저장소 - Internal : 개별앱만 접근가능, 파일탐색기에서 보이지 않는다.

* 내부저장소 경로 : /data/data/패키지명/files
* 스트림을 열고
* 내용을 쓴다.

2. 외부저장소 - External : 모든앱이 접근가능 > 권한필요

## LifeCycle

1. 생성과 관련된 생명주기

onCreate() -> onStart() -> onResume() -> Running

2. 소멸관련된 생명주기

onPause() -> onStop() -> onDestroy()
