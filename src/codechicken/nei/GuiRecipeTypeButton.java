package codechicken.nei;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiRecipeTypeButton extends GuiButton
{
    protected static final ResourceLocation guiTex = new ResourceLocation("textures/gui/widgets.png");
    
    public GuiRecipeTypeButton(int i, int j, int k, int l, int i1, String s)
    {
        super(i, j, k, l, i1, s);
    }
    
    public void drawButton(Minecraft minecraft, int i, int j)
    {
        if(!visible)
            return;

        GL11.glPushMatrix();
        GL11.glTranslatef(xPosition, yPosition+height, 0f);

        GL11.glRotatef(-90f, 0f, 0, 1f);


        FontRenderer fontrenderer = minecraft.fontRenderer;
        minecraft.renderEngine.bindTexture(guiTex);
        GL11.glColor4f(1, 1, 1, 1);
        boolean flag = i >= xPosition && j >= yPosition && i < xPosition + width && j < yPosition + height;

        // rotated and swapped height and width because the button drawing code can't handle it, and I don't feel like fixing it when we're rotating anyways
        LayoutManager.drawButtonBackground(0, 0, height, width, true, flag ? 2 : 1);
        mouseDragged(minecraft, i, j);

        int color;
        if(flag)
            color = 0xffffa0;
        else
            color = 0xe0e0e0;

        drawString(fontrenderer, displayString, 2, (width - 8) / 2, color);
        GL11.glPopMatrix();
    }
}
