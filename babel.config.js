module.exports = {
  presets: ['module:metro-react-native-babel-preset'],
  plugins: [
    [
      'module-resolver',
      {
        root: ['./src'],
        extensions: [
          '.ios.ts',
          '.android.ts',
          '.ts',
          '.ios.tsx',
          '.android.tsx',
          '.jsx',
          '.js',
          '.json',
        ],
        alias: {
          assets: './src/assets',
          screens: './src/screens',
          constants: './src/constants',
          components: './src/components',
          network: './src/network',
          storage: './src/storage',
          hooks: './src/hooks',
          navigation: './src/navigation',
          types: './src/types',
        },
      },
    ],
  ],
};
