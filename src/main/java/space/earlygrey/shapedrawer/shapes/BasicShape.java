package space.earlygrey.shapedrawer.shapes;

import com.badlogic.gdx.graphics.Color;

import space.earlygrey.shapedrawer.JoinType;
import space.earlygrey.shapedrawer.ShapeDrawer;
import space.earlygrey.shapedrawer.ShapeUtils.ConstantLineWidth;
import space.earlygrey.shapedrawer.ShapeUtils.LineWidthFunction;

public abstract class BasicShape<T extends BasicShape> {

    final ShapeDrawer drawer;

    final ConstantLineWidth CONSTANT_LINE_WIDTH = new ConstantLineWidth();
    LineWidthFunction lineWidth;
    JoinType joinType;

    float color;

    boolean filled;
    
    protected BasicShape(ShapeDrawer drawer) {
        this.drawer = drawer;
    }
    
    protected void reset(boolean filled) {
        this.filled = filled;
        lineWidth = CONSTANT_LINE_WIDTH.width(drawer.getDefaultLineWidth());
        joinType = JoinType.POINTY;
        color = drawer.getPackedColor();
    }
    
    protected void draw(Runnable drawCall) {
        float c = drawer.setColor(color);
        drawCall.run();
        drawer.setColor(c);
    }
    
    protected void setLineWidth(float width) {
        lineWidth = CONSTANT_LINE_WIDTH.width(width);
    }
    
    protected abstract T joinType(JoinType joinType);
    
    protected abstract T lineWidth(float width);
    
    protected abstract T color(Color color);

}
