# KeyVisualizerConfig file(.kvc)
フォーマットに従ったkvcファイルを読み込ませることで任意のキーマップを作成できます。  
kvcファイルは一行ずつ設定またはキーと対応付けられた図形を記述します。

## 命令一覧
- 図形
    - 四角
        - `RECT;text(:String);x(:Int),y(:Int),w(:Int),h(:Int);fillColor(:Color);activeColor(:Color);key(:Key)`
    - 円
        - `CIRCLE;text(:String);x(:Int),y(:Int),r(:Int);fillColor(:Color);activeColor(:Color);key(:Key)`
    - 多角形
        - `POLY;text(:String);x1(:Int),y1(:Int),x2,y2,x3,y3,...;fillColor(:Color);activeColor(:Color);key(:Key)`
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

## Colorの書式
`r,g,b`  
または  
`r,g,b,a`

## Keyの書式一覧
(編集中)
