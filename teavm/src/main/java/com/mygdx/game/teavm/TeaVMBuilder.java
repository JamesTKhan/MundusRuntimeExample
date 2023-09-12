package com.mygdx.game.teavm;

import com.github.xpenatan.gdx.backends.teavm.config.TeaBuildConfiguration;
import com.github.xpenatan.gdx.backends.teavm.config.TeaBuilder;
import com.github.xpenatan.gdx.backends.teavm.config.plugins.TeaReflectionSupplier;
import com.github.xpenatan.gdx.backends.teavm.gen.SkipClass;
import java.io.File;
import java.io.IOException;
import org.teavm.tooling.TeaVMTool;

/** Builds the TeaVM/HTML application. */
@SkipClass
public class TeaVMBuilder {
    public static void main(String[] args) throws IOException {
        TeaBuildConfiguration teaBuildConfiguration = new TeaBuildConfiguration();
        teaBuildConfiguration.assetsPath.add(new File("../assets"));
        teaBuildConfiguration.webappPath = new File("build/dist").getCanonicalPath();

        // Register any extra classpath assets here:
        teaBuildConfiguration.additionalAssetsClasspathFiles.add("com/mbrlabs/mundus/commons/shaders/skybox.frag.glsl");
        teaBuildConfiguration.additionalAssetsClasspathFiles.add("com/mbrlabs/mundus/commons/shaders/skybox.vert.glsl");
        teaBuildConfiguration.additionalAssetsClasspathFiles.add("com/mbrlabs/mundus/commons/shaders/terrain.uber.frag.glsl");
        teaBuildConfiguration.additionalAssetsClasspathFiles.add("com/mbrlabs/mundus/commons/shaders/terrain.uber.vert.glsl");
        teaBuildConfiguration.additionalAssetsClasspathFiles.add("com/mbrlabs/mundus/commons/shaders/water.uber.frag.glsl");
        teaBuildConfiguration.additionalAssetsClasspathFiles.add("com/mbrlabs/mundus/commons/shaders/water.uber.vert.glsl");
        teaBuildConfiguration.additionalAssetsClasspathFiles.add("com/mbrlabs/mundus/commons/shaders/depth.frag.glsl");
        teaBuildConfiguration.additionalAssetsClasspathFiles.add("com/mbrlabs/mundus/commons/shaders/depth.vert.glsl");
        teaBuildConfiguration.additionalAssetsClasspathFiles.add("com/mbrlabs/mundus/commons/shaders/shadowmap.frag.glsl");
        teaBuildConfiguration.additionalAssetsClasspathFiles.add("com/mbrlabs/mundus/commons/shaders/shadowmap.vert.glsl");
        teaBuildConfiguration.additionalAssetsClasspathFiles.add("com/mbrlabs/mundus/commons/shaders/light.glsl");
        teaBuildConfiguration.additionalAssetsClasspathFiles.add("com/mbrlabs/mundus/commons/shaders/compat.glsl");
        teaBuildConfiguration.additionalAssetsClasspathFiles.add("com/mbrlabs/mundus/commons/shaders/custom-gdx-pbr.fs.glsl");
        teaBuildConfiguration.additionalAssetsClasspathFiles.add("com/mbrlabs/mundus/commons/shaders/custom-gdx-pbr.vs.glsl");

        // Register any classes or packages that require reflection here:
        TeaReflectionSupplier.addReflectionClass("com.mbrlabs.mundus.commons.dto.SceneDTO");
        TeaReflectionSupplier.addReflectionClass("com.mbrlabs.mundus.commons.dto.GameObjectDTO");
        TeaReflectionSupplier.addReflectionClass("com.mbrlabs.mundus.commons.dto.WaterComponentDTO");
        TeaReflectionSupplier.addReflectionClass("com.mbrlabs.mundus.commons.dto.TerrainComponentDTO");
        TeaReflectionSupplier.addReflectionClass("com.mbrlabs.mundus.commons.dto.BaseLightDTO");
        TeaReflectionSupplier.addReflectionClass("com.mbrlabs.mundus.commons.dto.LightComponentDTO");
        TeaReflectionSupplier.addReflectionClass("com.mbrlabs.mundus.commons.dto.CustomPropertiesComponentDTO");
        TeaReflectionSupplier.addReflectionClass("com.mbrlabs.mundus.commons.dto.DirectionalLightDTO");
        TeaReflectionSupplier.addReflectionClass("com.mbrlabs.mundus.commons.dto.ShadowSettingsDTO");
        TeaReflectionSupplier.addReflectionClass("com.mbrlabs.mundus.commons.dto.FogDTO");
        TeaReflectionSupplier.addReflectionClass("com.mbrlabs.mundus.commons.dto.ModelComponentDTO");
        TeaReflectionSupplier.addReflectionClass("com.mbrlabs.mundus.commons.water.WaterResolution");
        TeaReflectionSupplier.addReflectionClass("com.mbrlabs.mundus.commons.shadows.ShadowResolution");
        TeaReflectionSupplier.addReflectionClass("com.mbrlabs.mundus.commons.env.lights.LightType");
        
        TeaVMTool tool = TeaBuilder.config(teaBuildConfiguration);
        tool.setMainClass(TeaVMLauncher.class.getName());
        TeaBuilder.build(tool);
    }
}
