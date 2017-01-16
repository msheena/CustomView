# CustomView
 <declare-styleable name="IconRatingBar">
        <attr name="starSize" format="dimension"/>
        <attr name="starCount" format="integer"/>
        <attr name="starSpace" format="integer"/>
        <attr name="starEmptyColor" format="reference|color"/>
        <attr name="starFullColor" format="reference|color"/>
        <attr name="starIcon" format="reference|string"/>
  </declare-styleable>
属性如上，支持自定义星星大小，星星个数，星星间距，未选中颜色，选中颜色使用及使用的icon
# 使用方法
<com.sheena.idesigin.component.IconRatingBar
       android:id="@+id/ratingbar"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       app:starEmptyColor="#000"
       app:starFullColor="#ffe599"
       app:starCount="5"
       app:starSize="16dp"
       app:starSpace="6"
       app:starIcon="@string/full_star_icon"
       />
