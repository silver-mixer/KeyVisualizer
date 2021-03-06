# KeyVisualizerConfig file(.kvc)
フォーマットに従ったkvcファイルを読み込ませることで任意のキーマップを作成できます。  
kvcファイルは一行ずつ設定またはキーと対応付けられた図形を記述します。

## バージョン
KVC Format v2.1

## 命令一覧
...で示されている箇所はカンマ(,)区切りで連続して書くことができます。  
| **型** | **説明** |
| --- | --- |
| String | 文字列 |
| Int | 整数 |
| Color | カラー(下記参照) |
| Key | キー(下記参照) |
- 図形
    - 四角
        - `RECT;text(:String);x(:Int),y(:Int),w(:Int),h(:Int);fillColor(:Color);activeColor(:Color);key(:Key),...`
    - 円
        - `CIRCLE;text(:String);x(:Int),y(:Int),r(:Int);fillColor(:Color);activeColor(:Color);key(:Key),...`
    - 多角形
        - `POLY;text(:String);x1(:Int),y1(:Int),x2,y2,x3,y3,...;fillColor(:Color);activeColor(:Color);key(:Key),...`
- 描画設定
    - 線太さ
        - `LINEWIDTH;width(:Int)`
    - フォントサイズ
        - `FONTSIZE;size(:Int)`
- その他
    - ウィンドウ余白
        - `PADDING;top(:Int),bottom(:Int),left(:Int),right(:Int)`
    - コメント
        - `#comment`
    - 日本語キーボード指定
        - `JPMODE`
        - 説明: `JPMODE`を指定することで日本語配列のキーボードに対応します。

## Colorの書式
`r,g,b`  
または  
`r,g,b,a`

## Keyの書式一覧
キーにはキーボードまたはマウスのボタンを指定できます。  
MB_&lt;N&gt;のNは整数で指定します。マウスボタン4を指定する際は"MB_4"と記述します。

※[US]はUS配列キーボードにのみ存在するキー、[JP]は日本語配列キーボードにのみ存在するキー、[US/JP]はどちらにも存在するキー(ただし配置が異なる場合あり)  
| **キー** | **説明** |
| --- | --- |
| LMB | 左クリック |
| MMB | ホイールクリック |
| RMB | 右クリック |
| MB_&lt;N&gt; | マウスボタンN |
| 0 | 0キー |
| 1 | 1キー |
| 2 | 2キー |
| 3 | 3キー |
| 4 | 4キー |
| 5 | 5キー |
| 6 | 6キー |
| 7 | 7キー |
| 8 | 8キー |
| 9 | 9キー |
| A | Aキー |
| B | Bキー |
| C | Cキー |
| D | Dキー |
| E | Eキー |
| F | Fキー |
| G | Gキー |
| H | Hキー |
| I | Iキー |
| J | Jキー |
| K | Kキー |
| L | Lキー |
| M | Mキー |
| N | Nキー |
| O | Oキー |
| P | Pキー |
| Q | Qキー |
| R | Rキー |
| S | Sキー |
| T | Tキー |
| U | Uキー |
| V | Vキー |
| W | Wキー |
| X | Xキー |
| Y | Yキー |
| Z | Zキー |
| BACK_QUOTE | `(逆引用符)キー[US] |
| EQUAL | =(等号)キー[US] |
| QUOTE | '(引用符)キー[US] |
| MINUS | -(マイナス)キー[US/JP] |
| OPEN_BRACKET | [(左角括弧)キー[US/JP] |
| CLOSE_BRACKET | ](右角括弧)キー[US/JP] |
| BACK_SLASH | \(バックスラッシュ)キー[US/JP] |
| SEMICOLON | ;(セミコロン)キー[US/JP] |
| COMMA | ,(カンマ)キー[US/JP] |
| PERIOD | .(ピリオド)キー[US/JP] |
| SLASH | /(スラッシュ)キー[US/JP] |
| CIRCUMFLEX | ^(サーカムフレックス)キー[JP] |
| YEN | ¥(円マーク)キー[JP] |
| AT | @(アットマーク)キー[JP] |
| COLON | :(コロン)キー[JP] |
| F1 | F1キー |
| F2 | F2キー |
| F3 | F3キー |
| F4 | F4キー |
| F5 | F5キー |
| F6 | F6キー |
| F7 | F7キー |
| F8 | F8キー |
| F9 | F9キー |
| F10 | F10キー |
| F11 | F11キー |
| F12 | F12キー |
| PRINTSCREEN | PrintScreenキー |
| PAUSE | Pause/Breakキー |
| LEFT_SHIFT | 左Shiftキー |
| LEFT_CONTROL | 左Controlキー |
| LEFT_ALT | 左Altキー |
| LEFT_WINDOWS | 左Windows/Super/Commandキー |
| RIGHT_SHIFT | 右Shiftキー |
| RIGHT_CONTROL | 右Controlキー |
| RIGHT_ALT | 右Altキー |
| RIGHT_WINDOWS | 右Windows/Super/Commandキー |
| NUM_LOCK | NumLockキー |
| CAPS_LOCK | CapsLockキー |
| SCROLL_LOCK | ScrollLockキー |
| LEFT | ←キー |
| UP | ↑キー |
| RIGHT | →キー |
| DOWN | ↓キー |
| PAGE_UP | PageUpキー |
| PAGE_DOWN | PageDownキー |
| HOME | Homeキー |
| END | Endキー |
| ESCAPE | Escapeキー |
| CONTEXT_MENU | ContextMenuキー |
| ENTER | Enterキー |
| BACKSPACE | Backspaceキー |
| INSERT | Insertキー |
| DELETE | Deleteキー |
| TAB | Tabキー |
| SPACE | Spaceキー |
| NUM_0 | テンキー0 |
| NUM_1 | テンキー1 |
| NUM_2 | テンキー2 |
| NUM_3 | テンキー3 |
| NUM_4 | テンキー4 |
| NUM_5 | テンキー5 |
| NUM_6 | テンキー6 |
| NUM_7 | テンキー7 |
| NUM_8 | テンキー8 |
| NUM_9 | テンキー9 |
| NUM_ENTER | テンキーEnter |
| ADD | テンキー+ |
| SUBTRACT | テンキー- |
| MULTIPLY | テンキー* |
| DIVIDE | テンキー/ |
| DECIMAL | テンキー. |
| HANKAKU_ZENKAKU | 半角全角キー |
| KATAKANA_HIRAGANA | カタカナひらがなキー |
| NON_CONVERSION | 無変換キー |
| CONVERSION | 変換キー |

## 更新履歴
| バージョン | 更新内容 |
| --- | --- |
| v1.0 | 初版 |
| v2.0 | マウスボタンを追加 |
| v2.1 | 複数のキーの割り当てを追加 |